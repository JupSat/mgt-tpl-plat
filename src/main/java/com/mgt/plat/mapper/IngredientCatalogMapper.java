package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.IngredientCatalog;
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
public interface IngredientCatalogMapper extends BaseMapper<IngredientCatalog> {
    Integer addCatalog(List<IngredientCatalog> list);

    List<IngredientCatalog> findIngredientCatalog(IngredientCatalog ingredientCatalog);

    Integer updateIngredientCatalogById(IngredientCatalog ingredientCatalog);

    Integer deleteByFoodCategoryById(List<Integer> list);

    Integer deleteIngredientCategoryById(Integer id);

    Integer findCategoryExisted(String category);
}
