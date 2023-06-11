package com.mgt.plat.entity.well;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mgt.plat.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "well_info")
public class WellInfo extends BaseEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主线id")
    private String wellId;

    @ApiModelProperty(value = "主线name")
    private String wellName;

    @ApiModelProperty(value = "主线标识")
    private Integer wellNum;

    @TableField(exist = false)
    @ApiModelProperty(value = "主线name")
    private List<NodeInfo> nodeInfoList;
 }
