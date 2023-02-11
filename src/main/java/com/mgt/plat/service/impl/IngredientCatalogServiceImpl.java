package com.mgt.plat.service.impl;

import com.mgt.plat.entity.IngredientCatalog;
import com.mgt.plat.mapper.IngredientCatalogMapper;
import com.mgt.plat.service.IngredientCatalogService;
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
public class IngredientCatalogServiceImpl implements IngredientCatalogService {
    private final static Logger logger = LoggerFactory.getLogger(IngredientCatalogServiceImpl.class);
    @Autowired
    private IngredientCatalogMapper ingredientCatalogMapper;

    @Override
    public ResultBean addCatalog(List<IngredientCatalog> list) {
        try {
            for (IngredientCatalog item : list) {
                String str = item.getIngredientCategory();
                System.out.println(str);
                Boolean isExisted = checkDuplicate(str);
                if (!isExisted) {
                    Integer num = ingredientCatalogMapper.addCatalog(list);
                    if (num > 0) {
                        return ResultBean.ok("新增成功!", true);
                    }
                } else {
                    return ResultBean.warn(str + "已存在!");
                }
            }
        } catch (Exception e) {
            logger.error("新增失败!", e);
        }
        return ResultBean.ok("新增失败!");
    }

    @Override
    public ResultBean findIngredientCatalog(IngredientCatalog ingredientCatalog) {
        try {
            List<IngredientCatalog> foodList = ingredientCatalogMapper.findIngredientCatalog(ingredientCatalog);
            if (foodList.size() > 0) {
                return ResultBean.ok("查询成功!", foodList);
            } else {
                return ResultBean.ok("您查询的数据不存在!");
            }
        } catch (Exception e) {
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean updateIngredientCatalogById(IngredientCatalog ingredientCatalog) {
        try {
            Integer type = ingredientCatalogMapper.updateIngredientCatalogById(ingredientCatalog);
            if (type == 1) {
                return ResultBean.ok("数据更新成功");
            }
        } catch (Exception e) {
            logger.error("更新失败!", e);
            return ResultBean.ok("更新失败");
        }

        return ResultBean.ok("更新失败!");
    }

    @Override
    public ResultBean deleteIngredientCategoryById(Integer id) {
        try {
            Integer type = ingredientCatalogMapper.deleteIngredientCategoryById(id);
            if (type > 0) {
                return ResultBean.ok("删除成功!");
            }
        } catch (Exception e) {
            logger.error("删除失败!", e);
            return ResultBean.warn("删除失败!请检查食材列表是否存在对此分类的索引，如有请先修改或删除");
        }
        return ResultBean.ok("无效ID!");
    }

    @Override
    public ResultBean deleteByFoodCategoryById(List<Integer> list) {
        try {
            Integer type = ingredientCatalogMapper.deleteByFoodCategoryById(list);
            if (type > 0) {
                return ResultBean.ok("删除成功!");
            }
        } catch (Exception e) {
            logger.error("删除失败!", e);
            return ResultBean.ok("删除失败!");
        }

        return ResultBean.ok("无效ID!");
    }

    @Override
    public ResultBean findCategoryExisted(String category) {
        try {
            Integer isExists = ingredientCatalogMapper.findCategoryExisted(category);
            if (isExists == 0) {
                return ResultBean.ok("success", true);
            }
        } catch (Exception e) {
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常");
        }
        return ResultBean.ok("该分类已存在!", false);
    }

    public Boolean checkDuplicate(String category) {
        try {
            Integer num = ingredientCatalogMapper.findCategoryExisted(category);
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }
}
