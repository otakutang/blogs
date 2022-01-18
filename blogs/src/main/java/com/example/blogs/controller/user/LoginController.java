package com.example.blogs.controller.user;

import com.example.blogs.base.BaseResponseVo;
import com.example.blogs.base.BaseTemplateController;
import com.example.blogs.exception.CustomException;
import com.example.blogs.pojo.bo.user.UserLoginBo;
import com.example.blogs.pojo.vo.request.user.UserLoginRequestVo;
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

/**
 * 用户登录
 *
 * @author otaku
 */
@Api(tags = "用户登录")
@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController extends BaseTemplateController {

    @Resource
    private UserService userService;


    @ApiOperation("用户信息登录")
    @PostMapping("/login")
    public BaseResponseVo login(@RequestBody @Validated UserLoginRequestVo userLoginRequestVo) {
        try {
            log.info("LoginController[login] userLoginRequestVo{}", userLoginRequestVo);
            return success(userService.login(UserLoginBo.builder()
                    .account(userLoginRequestVo.getAccount())
                    .password(userLoginRequestVo.getPassword()).build()
            ));
        } catch (CustomException customException) {
            log.warn("LoginController[login] errorMessage{}", customException.getMessage());
            customException.printStackTrace();
        } catch (Exception e) {
            log.error("LoginController[login] errorMessage{}", e.getMessage());
            e.printStackTrace();
        }
        return error();
    }

}
