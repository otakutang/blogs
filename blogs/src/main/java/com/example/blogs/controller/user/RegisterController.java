package com.example.blogs.controller.user;

import com.example.blogs.base.BaseResponseVo;
import com.example.blogs.base.BaseTemplateController;
import com.example.blogs.exception.CustomException;
import com.example.blogs.pojo.bo.user.UserRegisterBo;
import com.example.blogs.pojo.vo.request.user.UserRegisterRequestVo;
import com.example.blogs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户注册
 *
 * @author otaku
 */
@Api(tags = "用户注册")
@RequestMapping("/user")
@RestController
@Slf4j
public class RegisterController extends BaseTemplateController {

    @Resource
    private UserService userService;

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public BaseResponseVo register(@RequestBody @Validated UserRegisterRequestVo userVo) {
        log.info("RegisterController[add] userVo{}", userVo);
        int flag = 0;
        try {
            flag = userService.register(UserRegisterBo.builder()
                    .account(userVo.getAccount())
                    .name(userVo.getName())
                    .password(userVo.getPassword())
                    .checkPassWord(userVo.getCheckPassWord())
                    .phone(userVo.getPhone())
                    .createName(userVo.getCreateName())
                    .createTime(new Date()).build()
            );
            return success();
        } catch (CustomException customException) {
            customException.printStackTrace();
            log.warn("RegisterController[add] errorMsg{}", customException.getMessage());
            throw new CustomException(customException.getCode(), customException.getMessage());
        } catch (Exception e) {
            log.error("RegisterController[add] errorMsg{}", e.getMessage());
            e.printStackTrace();
        }
        return error();
    }
}
