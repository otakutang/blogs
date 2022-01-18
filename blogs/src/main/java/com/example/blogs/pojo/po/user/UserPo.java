package com.example.blogs.pojo.po.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * @author otaku
 * @TableName t_user
 */
@Data
public class UserPo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 生日
     */
    private Date birthday;
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