package com.mgt.plat.service;

import com.mgt.plat.entity.PurchaserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mgt.plat.utils.ResultBean;
/**
 * package name：com.mgt.plat.service
 * description：采购人  服务类
 * user：JupSat
 * modification time：2023-02-10 15:29
 * modified content：
 **/
public interface PurchaserInfoService extends IService<PurchaserInfo> {
    ResultBean findPurchaserList();

    ResultBean addPurchaser(PurchaserInfo purchaserInfo);
}
