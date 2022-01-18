package com.example.blogs.base;

import com.example.blogs.utils.BaseResponseUtil;

/**
 * 公共模板Controller
 * @author otaku
 */
public class BaseTemplateController<T>{

    /**
     * 无参数返回成功
     * @return BaseResponseVo
     */
    public BaseResponseVo<T> success(){
        return BaseResponseUtil.success();
    }

    /**
     * 有参数返回成功
     * @return BaseResponseVo
     */
    public BaseResponseVo<T> success(T data){
        return BaseResponseUtil.success(data);
    }

    /**
     * 有参数返回失败
     * @return BaseResponseVo
     */
    public BaseResponseVo<T> error(){
        return BaseResponseUtil.error();
    }

    /**
     * 有参数返回成功
     * @return BaseResponseVo
     */
    public BaseResponseVo<T> error(T data){
        return BaseResponseUtil.success(data);
    }


    /**
     * 自定义异常
     * @return BaseResponseVo
     */
    public BaseResponseVo<T> defined(int code,String message,boolean messageType,T data){
        return BaseResponseUtil.defined( code, message, messageType, data);
    }
}
