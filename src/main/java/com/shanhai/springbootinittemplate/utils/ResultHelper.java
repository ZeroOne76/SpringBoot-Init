package com.shanhai.springbootinittemplate.utils;

import com.shanhai.springbootinittemplate.common.BaseResponse;
import com.shanhai.springbootinittemplate.common.CodeEnum;

/**
 * 返回工具类
 *
 * @author shanghai
 * @version 1.0
 * @since 2023/3/24 17:02
 */
public class ResultHelper {
    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(20000, data, "成功");
    }

    /**
     * 状态码返回失败
     * @param codeEnum
     * @return
     */
    public static BaseResponse error(CodeEnum codeEnum) {
        return new BaseResponse<>(codeEnum);
    }

    /**
     * 自定义失败返回
     * @param code
     * @param message
     * @return
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, null, message);
    }

    /**
     * 自定义失败
     * @param codeEnum
     * @param message
     * @return
     */
    public static BaseResponse error(CodeEnum codeEnum, String message) {
        return new BaseResponse(codeEnum.getCode(), null, message);
    }
}
