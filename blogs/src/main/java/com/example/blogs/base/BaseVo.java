package com.example.blogs.base;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author otaku
 */
@Data
public class BaseVo {

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
