package com.mgt.plat.mapper;

import com.mgt.plat.entity.SkuInfo;
import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：sku接口
 * user：JupSat
 * modification time：2023-02-05 21:09
 * modified content：
 **/
public interface SkuInfoMapper {
    void addSkuInfo(List<SkuInfo> list);

    List<SkuInfo> findSkuInfoList(String skuName);

    Integer updateSkuInfoById(SkuInfo skuInfo);

    Integer deleteSkuInfoById(Integer id);
}
