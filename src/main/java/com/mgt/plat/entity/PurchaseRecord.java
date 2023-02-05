package com.mgt.plat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long id;
    private Date purchaseDate;
    private String foodName;
    private String foodCatalog ;
    private String unit;
    private Number num;
    private Number unitPrice;
    private Number budgetary;
    private Number purchaseNum;
    private Number purchasePrice;
    private Number  purchaseCost;
    private Number grossProfit;
    private String vendor;
    private String purchaser;
    private String note;
}
