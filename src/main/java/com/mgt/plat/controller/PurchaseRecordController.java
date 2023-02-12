package com.mgt.plat.controller;

import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.service.PurchaseRecordService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

/**
 * package name：com.mgt.plat.controller
 * description：采购记录controller
 * user：JupSat
 * modification time：2023-02-05 22:29
 * modified content：
 **/
@RestController
@RequestMapping("/purchaseRecord")
public class PurchaseRecordController {
    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @PostMapping("/add")
    public ResultBean addPurchaseRcd(@RequestBody List<PurchaseRecord> purchaseRcd){
        return purchaseRecordService.insertPurchaseRecord(purchaseRcd);
    }

    @PostMapping("/find")
    public ResultBean findPurchaseRcdList(@RequestBody HashMap<String, String> params){
        String ingredientId = params.get("ingredientId");
        String purchaseDate = params.get("purchaseDate");
        return purchaseRecordService.findPurchaseRecordList(ingredientId,  purchaseDate);
    }
    @PostMapping("/update")
    public ResultBean updatePurchaseRecord(@RequestBody PurchaseRecord purchaseRcd){
        purchaseRecordService.updatePurchaseRecord(purchaseRcd);
        return purchaseRecordService.updatePurchaseRecord(purchaseRcd);
    }

    @PostMapping("/delete")
    public ResultBean deletePurchaseRecordById(@RequestParam("id") Integer id){
        return purchaseRecordService.deletePurchaseRecord(id);
    }
}
