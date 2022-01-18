package com.example.blogs.utils;

import com.example.blogs.base.BaseResponseVo;
import com.example.blogs.constant.SystemConstant;

/**
 * 返回信息工具类
 * @author otaku
 */
public class BaseResponseUtil<T> {

    /**
     * 无参数成功返回
     */
    public static  <T>BaseResponseVo success(){
        return BaseResponseVo.builder()
                .code(SystemConstant.ResponseConstant.SUCCESS.getCode())
                .message(SystemConstant.ResponseConstant.SUCCESS.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 有参数成功返回
     */
    public static <T>BaseResponseVo success(T date){
        return BaseResponseVo.builder()
                .code(SystemConstant.ResponseConstant.SUCCESS.getCode())
                .message(SystemConstant.ResponseConstant.SUCCESS.getMessage())
                .timestamp(System.currentTimeMillis())
                .date(date)
                .build();
    }

//=============================================异常信息==============================================================

    /**
     * 异常：自定义返回信息
     */
    public static <T>BaseResponseVo error(String message){
        return BaseResponseVo.builder()
                .code(SystemConstant.ResponseConstant.ERROR.getCode())
                .errorMessage(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 无参数异常返回
     */
    public static <T>BaseResponseVo error(){
        return BaseResponseVo.builder()
                .code(SystemConstant.ResponseConstant.ERROR.getCode())
                .errorMessage(SystemConstant.ResponseConstant.ERROR.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 自定义返回信息
     * @param code:返回编码,message:返回异常信息,messageType:true:返回成功,false:返回失败,data:数据内容
     */
    public static <T>BaseResponseVo defined(int code,String message,boolean messageType,T data){
        if(messageType){
            return BaseResponseVo.builder()
                    .code(code)
                    .message(message)
                    .timestamp(System.currentTimeMillis())
                    .date(data)
                    .build();
        }
        return BaseResponseVo.builder()
                .code(code)
                .errorMessage(message)
                .timestamp(System.currentTimeMillis())
                .date(data)
                .build();

    }
}
