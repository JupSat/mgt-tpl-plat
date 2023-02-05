package com.mgt.plat.controller;

import com.mgt.plat.entity.SkuInfo;
import com.mgt.plat.service.SkuInfoService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

/**
 * package name：com.mgt.plat.controller
 * description： sku controller
 * user：JupSat
 * modification time：2023-02-05 22:29
 * modified content：
 **/
@RestController
@RequestMapping("/skuInfo")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;
    @PostMapping("/add")
    public ResultBean addSkuInfo(@RequestBody List<SkuInfo> skuInfo){
        return skuInfoService.insertSkuInfo(skuInfo);
    }

    @PostMapping("/find")
    public ResultBean findSkuInfoList(@RequestBody HashMap<String, String> params){
        String skuName = params.get("skuName");
         return skuInfoService.findSkuInfoList(skuName);
    }
    @PostMapping("/update")
    public ResultBean updatePurchaseRecord(@RequestBody SkuInfo skuInfo){
        skuInfoService.updateSkuInfoById(skuInfo);
        return skuInfoService.updateSkuInfoById(skuInfo);
    }
    @PostMapping("/delete")
    public ResultBean deletePurchaseRecordById(@RequestParam("id") Integer id){
        return skuInfoService.deleteSkuInfo(id);
    }
}
