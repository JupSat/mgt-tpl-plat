package com.mgt.plat.service.impl;

import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.entity.PurchaserInfo;
import com.mgt.plat.mapper.PurchaseRcdMapper;
import com.mgt.plat.mapper.PurchaserInfoMapper;
import com.mgt.plat.service.PurchaserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package name：com.mgt.plat.service.impl
 * description：采购人  实现类
 * user：JupSat
 * modification time：2023-02-10 15:29
 * modified content：
 **/
@Service
public class PurchaserInfoServiceImpl extends ServiceImpl<PurchaserInfoMapper, PurchaserInfo> implements PurchaserInfoService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaserInfoServiceImpl.class);
    @Autowired
    private PurchaserInfoMapper PurchaserInfoMapper;

    @Override
    public ResultBean findPurchaserList() {
        try{
            List<PurchaserInfo> purchaserList = PurchaserInfoMapper.findPurchaserList();
            if (purchaserList.size()>0){
                return ResultBean.ok("查询成功!",purchaserList);
            }else{
                return ResultBean.ok("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean addPurchaser(PurchaserInfo purchaserInfo) {
        try {
            int num = PurchaserInfoMapper.insert(purchaserInfo);;
            if (num>0){
                return ResultBean.ok("新增成功!",true);
            }
        }catch (Exception e){
             logger.error("系统异常!", e);
             return ResultBean.ok("系统异常！",false);
        }

        return ResultBean.ok("新增失败!",false);
    }
}
