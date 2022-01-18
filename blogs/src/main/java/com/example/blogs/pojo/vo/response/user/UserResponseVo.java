package com.example.blogs.pojo.vo.response.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 用户数据库返回参数
 * @author otaku
 */
@Data
public class UserResponseVo {

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
     * 重复输入密码
     */
    private String checkPassWord;

    /**
     * 用户名
     */
    private String name;

    /**
     * 生日
     */
    private Date birthday;
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
