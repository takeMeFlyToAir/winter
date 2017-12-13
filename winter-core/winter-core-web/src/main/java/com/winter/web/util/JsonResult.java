package com.winter.web.util;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    public ErrorCodeEnum errorCodeEnum;

    /**
     * 成功为success，其他为失败原因
     */
    public String message;

    /**
     * 返回值
     */
    public T data;
}
