package com.mgt.plat.service.impl;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.entity.FoodMonicker;
import com.mgt.plat.mapper.FoodMkMapper;
import com.mgt.plat.service.FoodMkService;
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
public class FoodMkServiceImpl implements FoodMkService {
    private final static Logger logger = LoggerFactory.getLogger(FoodCyServiceImpl.class);
    @Autowired
    private FoodMkMapper foodMkMapper;
    @Override
    public ResultBean insertFoodMonicker(List<FoodMonicker> list) {
        try{
            for (FoodMonicker item : list) {
                String name = item.getIngredientName();
                System.out.println(name);
                Boolean isExisted = checkDuplicate(name);
                if (!isExisted) {
                    Integer num = foodMkMapper.insertFoodMonicker(list);
                    if (num>0){
                        return ResultBean.ok("新增成功!",true);
                    }
                } else {
                    return ResultBean.warn(name + "已存在!");
                }
            }
        }catch (Exception e){
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！",false);
        }

        return ResultBean.ok("新增失败!",false);
    }

    @Override
    public ResultBean findMonicker(FoodMonicker foodMonicker) {
        try{
            List<FoodMonicker> list = foodMkMapper.findMonicker(foodMonicker);
            if (list.size()>0){
                return ResultBean.ok("查询成功！",list);
            }
        }catch (Exception e){
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！",null);
        }
        return ResultBean.ok("您查找的内容不存在！",null);
    }

    @Override
    public ResultBean updateFoodMonickerByFoodId(FoodMonicker foodMonicker) {
        try{
            Integer type = foodMkMapper.updateFoodMonickerByFoodId(foodMonicker);
            if (type>0){
                return ResultBean.ok("修改成功!","success");
            }
        }catch (Exception e){
            logger.error("系统异常!",e);
            return ResultBean.ok("系统异常！","error");
        }
        return ResultBean.ok("修改失败，请检查字段合法性!","error");
    }

//    @Override
//    public ResultBean deleteFoodMonickerById(List<Integer> list) {
//        try{
//            Integer type = foodMkMapper.deleteFoodMonickerById(list);
//            if (type>0){
//                return ResultBean.ok("删除成功!","success");
//            }
//        }catch (Exception e){
//            logger.error("系统异常!",e);
//            return ResultBean.ok("系统异常！","error");
//        }
//        return ResultBean.ok("删除失败!","error");
//    }

    @Override
    public ResultBean deleteIngredientById(Integer id) {
        try{
            Integer type = foodMkMapper.deleteIngredientById(id);
            if (type>0){
                return ResultBean.ok("删除成功!","success");
            }
        }catch (Exception e){
            logger.error("系统异常!",e);
            return ResultBean.ok("系统异常！","error");
        }
        return ResultBean.ok("删除失败!","error");
    }

    public Boolean checkDuplicate(String category) {
        try {
            Integer num = foodMkMapper.findIngredientExisted(category);
            if (num == 0){
                return false;
            }
        }catch (Exception e){
            return true;
        }
        return true;
    }
}
