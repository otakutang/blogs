package com.example.blogs.pojo.vo.request.user;

import com.example.blogs.base.BaseVo;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户登录请求VO
 * @author otaku
 */
@Data
public class UserLoginRequestVo implements Serializable {

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
}
