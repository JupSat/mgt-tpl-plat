package com.mgt.plat.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * package name：com.mgt.plat.entity
 * description：
 * user：lglhope
 * modification time：2023-02-02 15:29
 * modified content：
 **/
public class BaseEntity {

    @TableField(value = "create_time",fill = FieldFill.DEFAULT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    @ApiModelProperty(value = "创建时间")
    private String createTime;

//    @ApiModelProperty(value = "创建人")
//    private String creator;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/ShangHai")
    @ApiModelProperty(value = "修改时间")
    private String updateTime;

//    @ApiModelProperty(value = "修改人")
//    private String updater;

    /**
     * 下面的为冗余字段，但其定义可讨论  TODO
     */
//    @ApiModelProperty(value = "冗余字段")
//    private String string10;
}
