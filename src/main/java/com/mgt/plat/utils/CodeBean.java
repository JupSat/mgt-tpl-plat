package com.mgt.plat.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2022-12-21 11:26
 * modified content：
 **/

@Getter
@Setter
@ToString
public class CodeBean {
    private Integer code = 0;
    private String msg;
    private Object result;
    private Object token;
}
