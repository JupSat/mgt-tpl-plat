package com.mgt.plat.mapper;

import com.mgt.plat.entity.PurchaserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
/**
 * package name：com.mgt.plat.mapper
 * description：采购人mapper
 * user：JupSat
 * modification time：2023-02-10 15:29
 * modified content：
 **/
public interface PurchaserInfoMapper extends BaseMapper<PurchaserInfo> {
    List<PurchaserInfo> findPurchaserList();
}
