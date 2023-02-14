package com.mgt.plat.service;

import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.utils.ResultBean;
import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：采购记录service接口
 * user：JupSat
 * modification time：2023-02-05 20:49
 * modified content：
 **/
public interface PurchaseRecordService {
    ResultBean insertPurchaseRecord(List<PurchaseRecord> purchaseRecord);

    ResultBean deletePurchaseRecord(Integer id);

    ResultBean updatePurchaseRecord(PurchaseRecord purchaseRecord);

    ResultBean findPurchaseRecordById(Integer id);

    ResultBean findPurchaseRecordList(String ingredientId, String purchaseDate);

    ResultBean findPurchaseRecordListByPage(String ingredientId, String purchaseDate, Integer pageSize, Integer pageNum);

}
