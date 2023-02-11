package com.mgt.plat.controller;

import com.mgt.plat.entity.IngredientCatalog;
import com.mgt.plat.service.IngredientCatalogService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * package name：com.mgt.plat.controller
 * description：食品分类controller
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@RestController
@RequestMapping("/ingredientCatalog")
public class IngredientCatalogController {
    @Autowired
    private IngredientCatalogService ingredientCatalogService;

    @PostMapping("/add")
    public ResultBean addCatalog(@RequestBody List<IngredientCatalog> ingredientCatalog) {
        return ingredientCatalogService.addCatalog(ingredientCatalog);
    }

    /**
     * 查询食品分类
     */
    @PostMapping("/find")
    public ResultBean findIngredientCatalog(@RequestBody IngredientCatalog ingredientCatalog) {
        return ingredientCatalogService.findIngredientCatalog(ingredientCatalog);
    }

    @PostMapping("/update")
    public ResultBean updateIngredientCatalog(@RequestBody IngredientCatalog ingredientCatalog) {
        ingredientCatalogService.updateIngredientCatalogById(ingredientCatalog);
        return ingredientCatalogService.updateIngredientCatalogById(ingredientCatalog);
    }
    // @PostMapping("/delete")
    // public ResultBean deleteIngredientCatalog(@RequestBody List<Integer> list){
    // return ingredientCatalogService.deleteByFoodCategoryById(list);
    // }

    @PostMapping("/delete")
    public ResultBean deleteIngredientCategoryById(@RequestParam("id") Integer id) {
        return ingredientCatalogService.deleteIngredientCategoryById(id);
    }

    @GetMapping("/existed")
    public ResultBean findIngredientCategory(@RequestParam String category) {
        ingredientCatalogService.findCategoryExisted(category);
        return ingredientCatalogService.findCategoryExisted(category);
    }
}
