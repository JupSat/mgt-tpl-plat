package com.mgt.plat.controller;

import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.service.GoodsSupplierService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * package name：com.mgt.plat.controller
 * description：
 * user：lglhope
 * modification time：2023-02-02 19:45
 * modified content：
 **/
@RestController
@RequestMapping("/supplier")
public class GoodsSupplierController {

    @Autowired
    private GoodsSupplierService goodsSupplierService;

    @PostMapping("/add")
    public ResultBean addSupplier(@RequestBody GoodsSupplier goodsSupplier) {
        return goodsSupplierService.addSupplier(goodsSupplier);
    }

    @PostMapping("/batchAdd")
    public ResultBean batchAddSupplier(@RequestBody List<GoodsSupplier> goodsSupplierList) {
        return  goodsSupplierService.batchAddSupplier(goodsSupplierList);
    }

    @GetMapping("/findByName")
    public ResultBean findByName(@RequestParam(value = "name") String name) {
        return goodsSupplierService.findByName(name);
    }

    @GetMapping("/finaById")
    public ResultBean findById(@RequestParam(value = "id") String id) {
        return goodsSupplierService.findById(id);
    }

    @GetMapping("/findAll")
    public ResultBean findAllByName(@RequestParam(value = "name") String name) {
        return goodsSupplierService.findAllByName(name);
    }

    @PutMapping("/update")
    public ResultBean updateSupplier(@RequestBody GoodsSupplier goodsSupplier) {
        return goodsSupplierService.updateSupplier(goodsSupplier);
    }

    @DeleteMapping("/delete")
    public ResultBean deleteById(@RequestParam(value = "id") Long id) {
        return goodsSupplierService.deleteById(id);
    }
}
