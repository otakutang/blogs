package com.example.blogs.service;

import com.example.blogs.pojo.bo.user.UserLoginBo;
import com.example.blogs.pojo.bo.user.UserRegisterBo;
import com.example.blogs.pojo.vo.response.user.UserResponseVo;

/**
* @author otaku
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-01-17 21:37:50
*/
public interface UserService {

    /**
     * 用户注册
     * @param  userRegisterBo:用户注册信息
     * @return 0:失败,1:成功
     */
    int register(UserRegisterBo userRegisterBo);


    /**
     * 用户登录
     * @param  userLoginBo:用户登录信息
     * @return 0:失败,1:成功
     */
    String login(UserLoginBo userLoginBo);


    /**
     * 获取用户信息
     * @param  userLoginBo:用户登录信息
     * @return 0:失败,1:成功
     */
    UserResponseVo getUser(UserLoginBo userLoginBo);

}
