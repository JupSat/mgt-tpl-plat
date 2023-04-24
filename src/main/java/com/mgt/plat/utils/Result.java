package com.mgt.plat.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2023-04-24 19:59
 * modified content：
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    // 操作成功状态码为 0
    public static final int SUCCESS_CODE = 0;
    // 操作失败状态码为 1
    public static final int ERROR_CODE = 1;
    // 操作失败，缺少参数
    public static final int MISSING_PARAMETERS_ERROR_CODE = 40001;
    // 状态码
    private int code;
    // 提示信息
    private String message;
    // 响应数据
    private T data;
    /**
     * 操作成功，带有响应数据
     *
     * @param data 响应数据
     * @param <T>  响应数据类型
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(SUCCESS_CODE);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }
    /**
     * 操作成功，不带响应数据
     *
     * @return Result
     */
    public static Result<Void> success() {
        return success(null);
    }
    /**
     * 操作失败，带有错误信息
     *
     * @param message 错误信息
     * @param <T>     响应数据类型
     * @return Result
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(ERROR_CODE);
        result.setMessage(message);
        return result;
    }
    /**
     * 操作失败，缺少参数
     *
     * @return Result
     */
    public static Result<Void> missingParametersError() {
        return error("缺少参数");
    }
}