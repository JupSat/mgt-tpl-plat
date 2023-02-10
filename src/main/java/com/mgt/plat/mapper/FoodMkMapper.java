package com.mgt.plat.mapper;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.entity.FoodMonicker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * package name：com.mgt.plat.mapper
 * description：食品名称接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Mapper
public interface FoodMkMapper {
//    List<FoodMonicker> findMonicker(@Param("ingredientName") String ingredientName, @Param("ingredientCategory") String ingredientCategory);
    List<FoodMonicker> findMonicker(FoodMonicker foodMonicker);
    Integer insertFoodMonicker(List<FoodMonicker> list);

    Integer updateFoodMonickerByFoodId(FoodMonicker foodMonicker);

//    Integer deleteFoodMonickerById(List<Integer> list);

    Integer deleteIngredientById(Integer id);

    Integer findIngredientExisted(String ingredient);
}
