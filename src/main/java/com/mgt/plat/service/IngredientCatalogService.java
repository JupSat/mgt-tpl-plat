package com.mgt.plat.service;

import com.mgt.plat.entity.IngredientCatalog;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：食品分类service接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
public interface IngredientCatalogService {
    ResultBean addCatalog(List<IngredientCatalog> list);

    ResultBean findIngredientCatalog(IngredientCatalog ingredientCatalog);

    ResultBean updateIngredientCatalogById(IngredientCatalog ingredientCatalog);

    ResultBean deleteIngredientCategoryById(Integer id);

    ResultBean deleteByFoodCategoryById(List<Integer> list);

    ResultBean findCategoryExisted(String category);
}
