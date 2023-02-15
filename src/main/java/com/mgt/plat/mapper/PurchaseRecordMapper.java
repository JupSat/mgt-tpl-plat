package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mgt.plat.entity.PurchaseRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：采购记录接口
 * user：JupSat
 * modification time：2023-02-05 21:09
 * modified content：
 **/
public interface PurchaseRecordMapper extends BaseMapper<PurchaseRecord>, BatchInsertMapper<PurchaseRecord>  {
    void addPurchaseRcd(List<PurchaseRecord> purchaseRecord);

    List<PurchaseRecord> findPurchaseRcdList(@Param("ingredientId") Integer ingredientId, @Param("purchaseDate") String purchaseDate);

//    List<PurchaseRecord> findPurchaseRcdListByPage(@Param("ingredientId") Integer ingredientId, @Param("purchaseDate") String purchaseDate, Integer pageSize, Integer pageNum);

    IPage<PurchaseRecord> findPurchaseRcdListByPage (IPage<PurchaseRecord> page, @Param("ingredientId") Integer ingredientId, @Param("purchaseDate") String purchaseDate);

    Integer updatePurchaseRcdById(PurchaseRecord purchaseRecord);

    Integer deletePurchaseRcdById(Integer id);
}
