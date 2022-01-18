package com.example.blogs.constant;

import lombok.Builder;
import lombok.Getter;

/**
 * 系统级别枚举
 * @author otaku
 */
public class SystemConstant {

    /**
     * 公共返回枚举
     */
     public enum ResponseConstant{
        /**
         * SUCCESS:成功返回
         * ERROR:异常返回
         * NO_LOGIN:未登录返回
         */
        SUCCESS(200,"成功"),
        ERROR(500,"服务器内部异常"),
        NO_USER(400,"用户不存在"),
        NO_LOGIN(301,"用户未登录");

        int code;
        String message;

        ResponseConstant(int code, String message) {
            this.code=code;
            this.message=message;
        }

         public int getCode() {
             return code;
         }

         public String getMessage() {
             return message;
         }

         /**
          * 根据code获取message
          * @param code
          * @return message
          */
         public String getMessageName(int code){
             for (ResponseConstant responseConstant:ResponseConstant.values()) {
                if(responseConstant.getCode()==code){
                    return responseConstant.getMessage();
                }
             }
            return "";
         }
     }
}
