package com.example.blogs.exception;

import lombok.Data;

/**
 * 用户自定义异常
 * @author otaku
 */
@Data
public class CustomException extends RuntimeException{

    int code;
    String message;

    public CustomException(int code,String message){
        this.code=code;
        this.message=message;
    }
}
