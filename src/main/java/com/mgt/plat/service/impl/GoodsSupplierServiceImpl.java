package com.mgt.plat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.mapper.GoodsSupplierMapper;
import com.mgt.plat.service.GoodsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：
 * user：lglhope
 * modification time：2023-02-02 19:45
 * modified content：
 **/
@Service
public class GoodsSupplierServiceImpl extends ServiceImpl<GoodsSupplierMapper, GoodsSupplier> implements GoodsSupplierService {

    @Autowired
    private GoodsSupplierMapper goodsSupplierMapper;

    @Override
    public int addSupplier(GoodsSupplier goodsSupplier) {
        return goodsSupplierMapper.insert(goodsSupplier);
    }

    @Override
    public void batchAddSupplier(List<GoodsSupplier> goodsSupplierList) {
//        goodsSupplierMapper.batchInsertData(goodsSupplierList);
        this.saveOrUpdateBatch(goodsSupplierList);
    }

    @Override
    public GoodsSupplier findByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return goodsSupplierMapper.selectList(wrapper).stream().findFirst().orElse(null);
    }

    @Override
    public GoodsSupplier findById(String id) {
        return goodsSupplierMapper.querySupplierById(id);
    }

    @Override
    public List<GoodsSupplier> findAllByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        return goodsSupplierMapper.selectList(wrapper);
    }

    @Override
    public boolean updateSupplier(GoodsSupplier goodsSupplier) {
        return this.updateById(goodsSupplier);
    }

    @Override
    public int deleteById(String id) {
        return goodsSupplierMapper.deleteById(id);
    }

}
