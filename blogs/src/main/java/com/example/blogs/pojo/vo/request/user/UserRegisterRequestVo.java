package com.example.blogs.pojo.vo.request.user;

import com.example.blogs.base.BaseVo;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用户注册请求VO
 * @author otaku
 */
@Data
public class UserRegisterRequestVo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    @NotBlank(message = "登录账号不可为空")
    @ApiParam("登录账号")
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "密码不可为空")
    @ApiParam("密码")
    private String password;
    /**
     * 重复输入密码
     */
    @NotBlank(message = "重复输入密码不可为空")
    @ApiParam("重复输入密码")
    private String checkPassWord;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不可为空")
    @ApiParam("用户名")
    private String name;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不可为空")
    @ApiParam("手机号")
    private String phone;
}
