package com.mgt.plat.service.impl;

import com.mgt.plat.entity.FootClassify;
import com.mgt.plat.mapper.FootCyMapper;
import com.mgt.plat.service.FootCyService;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootCyServiceImpl implements FootCyService {
    private final static Logger logger = LoggerFactory.getLogger(FootCyServiceImpl.class);
    @Autowired
    private FootCyMapper footCyMapper;
    @Override
    public ResultBean addFootCy(List<FootClassify> list) {
        try {
            footCyMapper.addFoodCy(list);
            return  ResultBean.ok("新增成功");
        }catch (Exception e){
            logger.error("新增失败!", e);
        }
        return  ResultBean.ok("新增失败!");
    }


    @Override
    public ResultBean findFootCyList(FootClassify footClassify) {
        try{
            List<FootClassify> footList = footCyMapper.findFootCyList(footClassify);
            if (footList.size()>0){
                return ResultBean.ok("查询成功!",footList);
            }else{
                return ResultBean.ok("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean updateFootCategoryByFootId(FootClassify footClassify) {
        try {
            Integer type = footCyMapper.updateFootCategoryByFootId(footClassify);
            if (type==1){
                return ResultBean.ok("数据更新成功");
            }
        }catch (Exception e){
            logger.error("更新失败!", e);
        }

        return  ResultBean.ok("更新失败!");
    }

    @Override
    public ResultBean deleteByFootCategoryById(List<Integer> list) {
        try {
            Integer type = footCyMapper.deleteByFootCategoryById(list);
            if (type>0){
                return ResultBean.ok("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.ok("删除失败!");
        }

        return ResultBean.ok("无效ID!");
    }
}
