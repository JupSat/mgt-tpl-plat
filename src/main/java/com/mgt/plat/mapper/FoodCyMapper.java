package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.FoodClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * package name：com.mgt.plat.mapper
 * description：食品分类接口
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@Mapper
public interface FoodCyMapper extends BaseMapper<FoodClassify> {
    void addFoodCy(List<FoodClassify> list);

    List<FoodClassify> findFoodCyList(FoodClassify foodClassify);

    Integer updateFoodCategoryByFoodId(FoodClassify foodClassify);

    Integer deleteByFoodCategoryById(List<Integer> list);

    Integer deleteIngredientCategoryById(Integer id);

    Integer findCategoryExists(String category);
}
