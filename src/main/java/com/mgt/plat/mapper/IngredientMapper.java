package com.mgt.plat.mapper;

import com.mgt.plat.entity.Ingredient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：食品名称接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Mapper
public interface IngredientMapper {
    // List<Ingredient> findIngredient(@Param("ingredientName") String
    // ingredientName, @Param("ingredientCategory") String ingredientCategory);
    List<Ingredient> findIngredient(Ingredient ingredient);

    Integer insertIngredient(List<Ingredient> list);

    Integer updateIngredientById(Ingredient ingredient);

    // Integer deleteIngredientById(List<Integer> list);

    Integer deleteIngredientById(Integer id);

    Integer findIngredientExisted(String ingredient);
}
