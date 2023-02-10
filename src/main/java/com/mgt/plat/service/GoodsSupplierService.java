package com.mgt.plat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：
 * user：lglhope
 * modification time：2023-02-02 19:45
 * modified content：
 **/
public interface GoodsSupplierService extends IService<GoodsSupplier> {

    /**
     * 新增货物供应商
     * @param goodsSupplier
     * @return
     */
    ResultBean addSupplier(GoodsSupplier goodsSupplier);

    /**
     * 批量新增货物供应商
     * @param goodsSupplierList
     */
    ResultBean batchAddSupplier(List<GoodsSupplier> goodsSupplierList);

    /**
     * 根据供应商名称获取供应商信息
     * @param name
     * @return
     */
    ResultBean findByName(String name);

    /**
     * 根据供应商编号获取供应商信息
     * @param id
     * @return
     */
    ResultBean findById(String id);

    /**
     * 根据供应商名称模糊查询
     * @param name
     * @return
     */
    ResultBean  findAllByName(String name);

    /**
     * 修改供应商信息
     * @param goodsSupplier
     * @return
     */
    ResultBean updateSupplier(GoodsSupplier goodsSupplier);

    /**
     * 删除供应商
     * @param id
     * @return
     */
    ResultBean deleteById(Long id);
}
