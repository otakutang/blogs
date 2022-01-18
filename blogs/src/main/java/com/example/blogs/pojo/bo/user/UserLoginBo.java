package com.example.blogs.pojo.bo.user;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录BO
 *
 * @author otaku
 */
@Data
@Builder
public class UserLoginBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
