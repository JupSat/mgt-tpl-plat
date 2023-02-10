package com.mgt.plat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * package name：com.mgt.plat.entity
 * description：采购人entity
 * user：JupSat
 * modification time：2023-02-10 15:29
 * modified content：
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="采购人", description="采购人")
@TableName(value = "purchaser_info")
public class PurchaserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "采购人姓名")
    private String purchaserName;

    @ApiModelProperty(value = "采购人编号")
    private String purchaserId;

    @ApiModelProperty(value = "电话")
    private String purchaserPhone;

    @ApiModelProperty(value = "邮件")
    private String purchaserEmail;

    @ApiModelProperty(value = "备注")
    private String purchaserNote;


}
