package com.mgt.plat.mapper;

import com.mgt.plat.entity.PurchaseRecord;
import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：采购记录接口
 * user：JupSat
 * modification time：2023-02-05 21:09
 * modified content：
 **/
public interface PurchaseRcdMapper {
    void addPurchaseRcd(List<PurchaseRecord> purchaseRecord);

    List<PurchaseRecord> findPurchaseRcdList(String foodName, String purchaseDate);

    Integer updatePurchaseRcdById(PurchaseRecord purchaseRecord);

    Integer deletePurchaseRcdById(Integer id);
}