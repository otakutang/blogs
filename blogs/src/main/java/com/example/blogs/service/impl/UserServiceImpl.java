package com.example.blogs.service.impl;

import com.example.blogs.constant.SystemConstant;
import com.example.blogs.exception.CustomException;
import com.example.blogs.mapper.UserMapper;
import com.example.blogs.pojo.bo.user.UserLoginBo;
import com.example.blogs.pojo.bo.user.UserRegisterBo;
import com.example.blogs.pojo.dto.request.user.UserRequestDto;
import com.example.blogs.pojo.vo.response.user.UserResponseVo;
import com.example.blogs.service.UserService;
import com.example.blogs.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
* @author otaku
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-01-17 21:37:50
*/
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Value("${register-interval-time}")
    private Long registerIntervalTime;

    @Resource
    private RedisTemplate<String,Long> redisTemplate;

    @Resource
    UserMapper userMapper;



    /**
     * 用户注册
     * @param  userRegisterBo:用户注册信息
     * @return 0:失败,1:成功
     */
    @Override
    public int register(UserRegisterBo userRegisterBo) {
        log.info("UserServiceImpl[register]:userRegisterBo{}",userRegisterBo);
        String account = userRegisterBo.getAccount();
        String name=userRegisterBo.getName().isEmpty()?account:userRegisterBo.getName();
        //redis频繁操作校验
        Long redisValue = redisTemplate.opsForValue().get(account);
        if(!ObjectUtils.isEmpty(redisValue)){
            long nowTime = System.currentTimeMillis();
            Long redisTime = redisTemplate.opsForValue().get(userRegisterBo.getAccount());
            long sumTime = redisTime + registerIntervalTime;
            if(nowTime<=sumTime){
                log.warn("UserServiceImpl[register]:userRegisterBo{}",userRegisterBo);
                throw new CustomException(SystemConstant.ResponseConstant.ERROR.getCode(), "频繁操作，请稍后再试");
            }
        }
        redisTemplate.opsForValue().set(account,System.currentTimeMillis());
        //用户校验
        check(userRegisterBo);
        userMapper.insert(UserRequestDto.builder()
            .account(account)
                .password(userRegisterBo.getPassword())
                .name(name)
                .phone(userRegisterBo.getPhone())
                .createName(userRegisterBo.getCreateName())
                .createTime(userRegisterBo.getCreateTime())
                .build()
        );

        return 0;
    }

    /**
     * 用户登录
     * @param  userLoginBo:用户登录信息
     * @return
     */
    @Override
    public String login(UserLoginBo userLoginBo) {
        String account = userLoginBo.getAccount();
        String password=userLoginBo.getPassword();
        int count = userMapper.count(UserRequestDto.builder().account(account).password(password).build());
        if(count== BigDecimal.ROUND_UP){
            throw new CustomException(SystemConstant.ResponseConstant.NO_USER.getCode(), "账号密码错误,请重新输入");
        }
        return JwtUtil.sign(account, password);
    }

    @Override
    public UserResponseVo getUser(UserLoginBo userLoginBo) {
        return null;
    }

    /**
     * 用户校验
     * @param userRegisterBo 用户信息
     */
    private void check(UserRegisterBo userRegisterBo) {
        String account= userRegisterBo.getAccount();
        int count = userMapper.count(UserRequestDto.builder().account(account).build());
        if(count>0){
            throw new CustomException(SystemConstant.ResponseConstant.ERROR.getCode(),"该账号已存在");
        }
        String checkPassWord = userRegisterBo.getCheckPassWord();
        String password = userRegisterBo.getPassword();
        if(!password.equals(checkPassWord)){
            throw new CustomException(SystemConstant.ResponseConstant.ERROR.getCode(),"二次输入密码异常");
        }
    }
}




