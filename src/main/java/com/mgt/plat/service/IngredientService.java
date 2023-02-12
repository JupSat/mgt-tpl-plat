package com.mgt.plat.service;

import com.mgt.plat.entity.Ingredient;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：食品名称service接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
public interface IngredientService {
    ResultBean insertIngredient(List<Ingredient> list);

    // ResultBean findIngredientById(Integer number);

    ResultBean updateIngredientById(Ingredient ingredient);

    // ResultBean deleteIngredientById(List<Integer> list);

    ResultBean deleteIngredientById(Integer id);

    ResultBean findIngredient(Ingredient ingredient);
}
