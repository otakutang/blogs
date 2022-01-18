package com.example.blogs.pojo.bo.user;

import com.example.blogs.base.BaseVo;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户注册BO
 *
 * @author otaku
 */
@Data
@Builder
public class UserRegisterBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 重复输入密码
     */
    private String checkPassWord;

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;
}
