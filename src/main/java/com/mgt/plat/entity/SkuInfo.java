package com.mgt.plat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long skuName;
    private Number price;
    private String img;
    private String note;
}