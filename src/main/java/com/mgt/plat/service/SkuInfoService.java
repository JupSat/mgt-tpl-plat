package com.mgt.plat.service;

import com.mgt.plat.entity.SkuInfo;
import com.mgt.plat.utils.ResultBean;
import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：sku service接口
 * user：JupSat
 * modification time：2023-02-05 20:54
 * modified content：
 **/
public interface SkuInfoService {
    ResultBean insertSkuInfo(List<SkuInfo> list);

    ResultBean deleteSkuInfo(Integer number);

    ResultBean updateSkuInfoById(SkuInfo skuInfo);

    ResultBean findSkuInfoList(String skuName);
}
