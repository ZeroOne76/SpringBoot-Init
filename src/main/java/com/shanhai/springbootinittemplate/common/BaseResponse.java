package com.shanhai.springbootinittemplate.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 基础返回类
 *
 * @author shanghai
 * @version 1.0
 * @since 2023/3/24 16:53
 */

@Data
@ToString
@AllArgsConstructor
public class BaseResponse <T> implements Serializable {
    //返回状态码
    private int code;

    //返回数据
    private T data;

    //返回信息
    private String message;

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(CodeEnum codeEnum) {
        this(codeEnum.getCode(), null, codeEnum.getMessage());
    }
}
