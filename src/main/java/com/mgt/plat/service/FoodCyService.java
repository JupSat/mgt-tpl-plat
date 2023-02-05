package com.mgt.plat.service;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.utils.ResultBean;

import java.util.List;
/**
 * package name：com.mgt.plat.service
 * description：食品分类service接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
public interface FoodCyService {
    ResultBean addFoodCy(List<FoodClassify> list);

    ResultBean findFoodCyList(FoodClassify foodClassify);

    ResultBean updateFoodCategoryByFoodId(FoodClassify foodClassify);

    ResultBean deleteByFoodCategoryById(List<Integer> list);

    ResultBean findCategoryExists(String category);
}
