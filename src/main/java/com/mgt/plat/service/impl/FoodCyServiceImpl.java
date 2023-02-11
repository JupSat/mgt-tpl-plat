package com.mgt.plat.service.impl;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.mapper.FoodCyMapper;
import com.mgt.plat.service.FoodCyService;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * package name：com.mgt.plat.service.impl
 * description：
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Service
public class FoodCyServiceImpl implements FoodCyService {
    private final static Logger logger = LoggerFactory.getLogger(FoodCyServiceImpl.class);
    @Autowired
    private FoodCyMapper foodCyMapper;
    @Override
    public ResultBean addFoodCy(List<FoodClassify> list) {
        try {
            for (FoodClassify item : list) {
                String str = item.getIngredientCategory();
                System.out.println(str);
                Boolean isExisted = checkDuplicate(str);
                if (!isExisted) {
                    Integer num = foodCyMapper.addFoodCy(list);
                    if (num>0){
                        return ResultBean.ok("新增成功!",true);
                    }
                 } else {
                    return ResultBean.warn(str + "已存在!");
                }
            }
        }catch (Exception e){
            logger.error("新增失败!", e);
        }
        return  ResultBean.ok("新增失败!");
    }


    @Override
    public ResultBean findFoodCyList(FoodClassify foodClassify) {
        try{
            List<FoodClassify> foodList = foodCyMapper.findFoodCyList(foodClassify);
            if (foodList.size()>0){
                return ResultBean.ok("查询成功!",foodList);
            }else{
                return ResultBean.ok("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean updateFoodCategoryByFoodId(FoodClassify foodClassify) {
        try {
            Integer type = foodCyMapper.updateFoodCategoryByFoodId(foodClassify);
            if (type==1){
                return ResultBean.ok("数据更新成功");
            }
        }catch (Exception e){
            logger.error("更新失败!", e);
            return ResultBean.ok("更新失败");
        }

        return  ResultBean.ok("更新失败!");
    }

    @Override
    public ResultBean deleteIngredientCategoryById(Integer id) {
        try {
            Integer type = foodCyMapper.deleteIngredientCategoryById(id);
            if (type>0){
                return ResultBean.ok("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.warn("删除失败!请检查食材列表是否存在对此分类的索引，如有请先修改或删除");
        }
        return ResultBean.ok("无效ID!");
    }

    @Override
    public ResultBean deleteByFoodCategoryById(List<Integer> list) {
        try {
            Integer type = foodCyMapper.deleteByFoodCategoryById(list);
            if (type>0){
                return ResultBean.ok("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.ok("删除失败!");
        }

        return ResultBean.ok("无效ID!");
    }

    @Override
    public ResultBean findCategoryExisted(String category) {
        try {
            Integer isExists = foodCyMapper.findCategoryExisted(category);
            if (isExists == 0){
                return ResultBean.ok("success",true);
            }
        }catch (Exception e){
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常");
        }
        return ResultBean.ok("该分类已存在!",false);
    }

     public Boolean checkDuplicate(String category) {
        try {
            Integer num = foodCyMapper.findCategoryExisted(category);
            if (num == 0){
                return false;
            }
        }catch (Exception e){
            return true;
        }
        return true;
    }
}
