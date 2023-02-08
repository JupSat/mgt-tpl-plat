package com.mgt.plat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * package name：com.mgt.plat.entity
 * description：Sku信息
 * user：JupSat
 * modification time：2023-02-05 20:43
 * modified content：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuInfo {
    private long id;
    private String skuName;
    private BigDecimal skuNum;
    private String skuUnit;
    private BigDecimal conversionRate;
    private BigDecimal optionalPrice;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private String note;
}
