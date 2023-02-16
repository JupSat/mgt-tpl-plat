package com.mgt.plat.controller;

import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.service.PurchaseRecordService;
import com.mgt.plat.utils.ExcelComponent;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @PostMapping("/findByPage")
    public ResultBean findPurchaseRcdListByPage(@RequestBody HashMap<String, String> params){
        String ingredientId = params.get("ingredientId");
        String purchaseDate = params.get("purchaseDate");

        Integer pageSize = Integer.valueOf(params.get("pageSize"));
        Integer pageNum = Integer.valueOf(params.get("pageNum"));
        return purchaseRecordService.findPurchaseRecordListByPage(ingredientId,  purchaseDate, pageSize, pageNum);
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

    @Resource
    private ExcelComponent excelComponent;

    @PostMapping("/import")
    public ResultBean importPurchaseRecord(@RequestParam("file") MultipartFile file) throws IOException {
        return excelComponent.importPurchaseRecordFile(file);
    }

    @GetMapping("/export")
    public void exportPurchaseRecord(HttpServletResponse response) {
        purchaseRecordService.exportPurchaseRecordFile(response);
    }
}
