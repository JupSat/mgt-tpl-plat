package com.mgt.plat.service.impl;

import com.mgt.plat.entity.SkuInfo;
import com.mgt.plat.mapper.SkuInfoMapper;
import com.mgt.plat.service.SkuInfoService;
import com.mgt.plat.utils.ResultBean;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * package name：com.mgt.plat.service.impl
 * description：
 * user：JupSat
 * modification time：2023-02-05 20:57
 * modified content：
 **/
@Service
public class SkuInfoServiceImpl implements SkuInfoService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseRecordServiceImpl.class);
    @Autowired
    private SkuInfoMapper skuInfoMapper;
    @Override
    public ResultBean<T> insertSkuInfo(List<SkuInfo> list) {
        try {
            skuInfoMapper.addSkuInfo(list);
            return  ResultBean.success("新增成功");
        }catch (Exception e){
            logger.error("新增失败!", e);
        }
        return  ResultBean.success("新增失败!");
    }

    @Override
    public ResultBean<T> deleteSkuInfo(Integer id) {
        try {
            Integer type = skuInfoMapper.deleteSkuInfoById(id);
            if (type>0){
                return ResultBean.success("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.success("删除失败!");
        }
        return ResultBean.success("无效ID!");
    }

    @Override
    public ResultBean<T> updateSkuInfoById(SkuInfo skuInfo) {
        try {
            Integer type = skuInfoMapper.updateSkuInfoById(skuInfo);
            if (type==1){
                return ResultBean.success("数据更新成功");
            }
        }catch (Exception e){
            logger.error("更新失败!", e);
            return ResultBean.success("更新失败");
        }
        return  ResultBean.success("更新失败!");
    }



    @Override
    public ResultBean<List<SkuInfo>> findSkuInfoList(SkuInfo skuInfo) {
        try{
            List<SkuInfo> skuInfoList = skuInfoMapper.findSkuInfoList(skuInfo);
            return ResultBean.success("查询成功!",skuInfoList);
        }catch (Exception e){
            return ResultBean.success("查询失败!");
        }
    }
}
