package com.mgt.plat.entity;

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
public class PurchaseRecord {
    private Long id;
    private String purchaseDate;
    private Long ingredientId;
    private Long ingredientCatalogId ;
    private String unit;
    private BigDecimal num;
    private BigDecimal unitPrice;
    private BigDecimal budgetary;
    private BigDecimal purchaseNum;
    private BigDecimal purchasePrice;
    private BigDecimal  purchaseCost;
    private BigDecimal grossProfit;
    private String vendor;
    private String purchaser;
    private String note;
    private Date createTime;
    private Date updateTime;
}
