package com.example.blogs.mapper;

import com.example.blogs.pojo.dto.request.user.UserRequestDto;

/**
 * @author otaku
 * @description 针对表【t_user】的数据库操作Mapper
 * @createDate 2022-01-17 21:37:50
 * @Entity com.example.blogs.pojo.po.user.TUser
 */
public interface UserMapper {


    /**
     * 根据用户条件获取用户数量
     *
     * @param userRequestDto 用户信息
     * @return 0~
     */
    int count(UserRequestDto userRequestDto);

    /**
     * 新增用户信息
     *
     * @param userRequestDto 用户信息
     * @return 0~1
     */
    int insert(UserRequestDto userRequestDto);
}




