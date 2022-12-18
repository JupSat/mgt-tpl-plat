package com.mgt.plat.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2022-12-17 12:49
 * modified content：
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean {
    private Integer status = 0;
    private String msg;
    private Object result;

    public static ResultBean build() {
        return new ResultBean();
    }

    public static ResultBean ok(String msg) {
        return new ResultBean(200, msg, null);
    }

    public static ResultBean ok(String msg, Object result) {
        return new ResultBean(200, msg, result);
    }

    public static ResultBean ok(Object result) {
        return new ResultBean(200, "ok", result);
    }

    public static ResultBean warn(String msg) {
        return new ResultBean(204, msg, null);
    }

    public static ResultBean warn(String msg, Object result) {
        return new ResultBean(204, msg, result);
    }

    public static ResultBean error(String msg) {
        return new ResultBean(500, msg, null);
    }

    public static ResultBean error(String msg, Object result) {
        return new ResultBean(500, msg, result);
    }

}
