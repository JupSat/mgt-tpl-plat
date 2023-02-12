package com.mgt.plat.controller;


import com.mgt.plat.entity.PurchaserInfo;
import com.mgt.plat.service.PurchaserInfoService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * package name：com.mgt.plat.controller
 * description：采购人
 * user：JupSat
 * modification time：2023-02-10 15:29
 * modified content：
 **/
@RestController
@RequestMapping("/purchaserInfo")
public class PurchaserInfoController {
    @Autowired
    private PurchaserInfoService purchaserInfoService;

    @PostMapping("/add")
    public ResultBean addSupplier(@RequestBody PurchaserInfo purchaserInfo) {
        return purchaserInfoService.addPurchaser(purchaserInfo);
    }
    @GetMapping("/findAll")
    public ResultBean findPurchaseRcdList(){
        return purchaserInfoService.findPurchaserList();
    }
}

