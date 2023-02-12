package com.mgt.plat.service.impl;

import com.mgt.plat.entity.Ingredient;
import com.mgt.plat.mapper.IngredientMapper;
import com.mgt.plat.service.IngredientService;
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
public class IngredientServiceImpl implements IngredientService {
    private final static Logger logger = LoggerFactory.getLogger(IngredientCatalogServiceImpl.class);
    @Autowired
    private IngredientMapper ingredientMapper;

    @Override
    public ResultBean insertIngredient(List<Ingredient> list) {
        try {
            for (Ingredient item : list) {
                String name = item.getIngredientName();
                System.out.println(name);
                Boolean isExisted = checkDuplicate(name);
                if (!isExisted) {
                    Integer num = ingredientMapper.insertIngredient(list);
                    if (num > 0) {
                        return ResultBean.ok("新增成功!", true);
                    }
                } else {
                    return ResultBean.warn(name + "已存在!");
                }
            }
        } catch (Exception e) {
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！", false);
        }

        return ResultBean.ok("新增失败!", false);
    }

    @Override
    public ResultBean findIngredient(Ingredient ingredient) {
        try {
            List<Ingredient> list = ingredientMapper.findIngredient(ingredient);
            if (list.size() > 0) {
                return ResultBean.ok("查询成功！", list);
            }
        } catch (Exception e) {
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！", null);
        }
        return ResultBean.ok("您查找的内容不存在！", null);
    }

    @Override
    public ResultBean updateIngredientById(Ingredient ingredient) {
        try {
            Integer type = ingredientMapper.updateIngredientById(ingredient);
            if (type > 0) {
                return ResultBean.ok("修改成功!", "success");
            }
        } catch (Exception e) {
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！", "error");
        }
        return ResultBean.ok("修改失败，请检查字段合法性!", "error");
    }

    // @Override
    // public ResultBean deleteIngredientById(List<Integer> list) {
    // try{
    // Integer type = ingredientMapper.deleteIngredientById(list);
    // if (type>0){
    // return ResultBean.ok("删除成功!","success");
    // }
    // }catch (Exception e){
    // logger.error("系统异常!",e);
    // return ResultBean.ok("系统异常！","error");
    // }
    // return ResultBean.ok("删除失败!","error");
    // }

    @Override
    public ResultBean deleteIngredientById(Integer id) {
        try {
            Integer type = ingredientMapper.deleteIngredientById(id);
            if (type > 0) {
                return ResultBean.ok("删除成功!", "success");
            }
        } catch (Exception e) {
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！", "error");
        }
        return ResultBean.ok("删除失败!", "error");
    }

    public Boolean checkDuplicate(String category) {
        try {
            Integer num = ingredientMapper.findIngredientExisted(category);
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }
}
