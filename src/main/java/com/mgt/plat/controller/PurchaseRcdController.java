package com.mgt.plat.controller;

import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.service.PurchaseRcdService;
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
public class PurchaseRcdController {
    @Autowired
    private PurchaseRcdService purchaseRcdService;

    @PostMapping("/add")
    public ResultBean addPurchaseRcd(@RequestBody List<PurchaseRecord> purchaseRcd){
        return purchaseRcdService.insertPurchaseRecord(purchaseRcd);
    }

    @PostMapping("/find")
    public ResultBean findPurchaseRcdList(@RequestBody HashMap<String, String> params){
        String foodName = params.get("foodName");
        String purchaseDate = params.get("purchaseDate");
        return purchaseRcdService.findPurchaseRecordList(foodName,  purchaseDate);
    }
    @PostMapping("/update")
    public ResultBean updatePurchaseRecord(@RequestBody PurchaseRecord purchaseRcd){
        purchaseRcdService.updatePurchaseRecord(purchaseRcd);
        return purchaseRcdService.updatePurchaseRecord(purchaseRcd);
    }

    @PostMapping("/delete")
    public ResultBean deletePurchaseRecordById(@RequestParam("id") Integer id){
        return purchaseRcdService.deletePurchaseRecord(id);
    }
}
