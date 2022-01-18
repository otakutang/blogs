package com.example.blogs.exception;


import com.example.blogs.base.BaseResponseVo;
import com.example.blogs.utils.BaseResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


/**
 * 全局异常拦截
 *
 * @author otaku
 */
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponseVo handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        List<FieldError> bindingResult = e.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : bindingResult) {
            log.error("{}:{}", fieldError.getField(), fieldError.getDefaultMessage());
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
        }
        String message = sb.substring(0, sb.length() - 1);
        return BaseResponseUtil.error(message);
    }

    @ExceptionHandler({CustomException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponseVo handleCustomException(CustomException customException) {
        return BaseResponseUtil.error(customException.message);
    }

}
