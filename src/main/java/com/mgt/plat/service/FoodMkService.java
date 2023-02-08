package com.mgt.plat.service;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.entity.FoodMonicker;
import com.mgt.plat.utils.ResultBean;

import java.util.List;
/**
 * package name：com.mgt.plat.service
 * description：食品名称service接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
public interface FoodMkService {
    ResultBean insertFoodMonicker(List<FoodMonicker> list);

//    ResultBean findMonickerById(Integer number);

    ResultBean updateFoodMonickerByFoodId(FoodMonicker foodMonicker);

//    ResultBean deleteFoodMonickerById(List<Integer> list);

    ResultBean deleteIngredientById(Integer id);

    ResultBean findMonicker(FoodMonicker foodMonicker);
}
