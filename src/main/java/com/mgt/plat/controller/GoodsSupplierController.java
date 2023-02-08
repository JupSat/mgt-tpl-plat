package com.mgt.plat.controller;

import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.service.GoodsSupplierService;
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
@RestController("/supplier")
public class GoodsSupplierController {

    @Autowired
    private GoodsSupplierService goodsSupplierService;

    @PostMapping("/add")
    public void addSupplier(@RequestBody GoodsSupplier goodsSupplier) {
        goodsSupplierService.addSupplier(goodsSupplier);
    }

    @PostMapping("/batchadd")
    public void batchAddSupplier(@RequestBody List<GoodsSupplier> goodsSupplierList) {
        goodsSupplierService.batchAddSupplier(goodsSupplierList);
    }

    @GetMapping("/finabyname")
    public GoodsSupplier findByName(@RequestParam(value = "name") String name) {
        return goodsSupplierService.findByName(name);
    }

    @GetMapping("/finabyid")
    public GoodsSupplier findById(@RequestParam(value = "id") String id) {
        return goodsSupplierService.findById(id);
    }

    @GetMapping("/finaAll")
    public List<GoodsSupplier> findAllByName(@RequestParam(value = "name") String name) {
        return goodsSupplierService.findAllByName(name);
    }

    @PutMapping("/update")
    public boolean updateSupplier(@RequestBody GoodsSupplier goodsSupplier) {
        return goodsSupplierService.updateSupplier(goodsSupplier);
    }

    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(value = "id") String id) {
        return goodsSupplierService.deleteById(id) == 1;
    }


}
