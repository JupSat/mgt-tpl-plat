package com.mgt.plat.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * package name：com.mgt.plat.entity
 * description：采购记录
 * user：JupSat
 * modification time：2023-02-05 20:37
 * modified content：
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("purchase_records")
public class PurchaseRecord {
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Long id;
    @ColumnWidth(12)
    @ExcelProperty(value = "日期")
    private String purchaseDate;
    @ExcelProperty(value = "食材名称")
    private Long ingredientId;
    @ExcelProperty(value = "食材分类")
    private Long ingredientCatalogId ;

    @ExcelProperty(value = "单位")
    private String unit;
    @ExcelProperty(value = "数量")
    private BigDecimal num;

    @ExcelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ExcelProperty(value = "预算")
    private BigDecimal budgetary;

    @ExcelProperty(value = "采购量")
    private BigDecimal purchaseNum;

    @ExcelProperty(value = "采购价")
    private BigDecimal purchasePrice;

    @ExcelProperty(value = "花费")
    private BigDecimal  purchaseCost;

    @ExcelProperty(value = "毛利")
    private BigDecimal grossProfit;

    @ExcelProperty(value = "供应商")
    private String vendor;

    @ExcelProperty(value = "采购人")
    private String purchaser;

    @ExcelProperty(value = "备注")
    private String note;
    @ColumnWidth(22)
    @ExcelProperty(value = "创建时间")
    private Date createTime;
    @ColumnWidth(22)
    @ExcelProperty(value = "更新时间")
    private Date updateTime;
}
