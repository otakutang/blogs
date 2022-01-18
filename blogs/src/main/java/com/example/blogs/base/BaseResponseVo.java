package com.example.blogs.base;

import lombok.Builder;
import lombok.Data;

/**
 * @author otaku
 */
@Data
@Builder
public class BaseResponseVo<T> {

    /**
     * 编码code
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 异常返回信息
     */
    private String errorMessage;

    /**
     * 返回内容
     */
    private T date;

    /**
     * 返回时间
     */
    private long timestamp;
}
