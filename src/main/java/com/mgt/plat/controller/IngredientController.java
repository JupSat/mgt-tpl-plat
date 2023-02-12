package com.mgt.plat.controller;

import com.mgt.plat.entity.Ingredient;
import com.mgt.plat.service.IngredientService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * package name：com.mgt.plat.controller
 * description：食品名称controller
 * user：fanjidong321
 * modification time：2023-2-4
 * modified content：
 **/
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/add")
    public ResultBean insertIngredient(@RequestBody List<Ingredient> list) {
        return ingredientService.insertIngredient(list);
    }
    // @GetMapping("/find")
    // public ResultBean findIngredient(@RequestParam Integer number){
    // return ingredientService.findIngredientById(number);
    // }

    @PostMapping("/find")
    public ResultBean findIngredientCatalog(@RequestBody Ingredient ingredient) {
        return ingredientService.findIngredient(ingredient);
    }

    @PostMapping("/update")
    public ResultBean updateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.updateIngredientById(ingredient);
        return ingredientService.updateIngredientById(ingredient);
    }
    // @PostMapping("delete")
    // public ResultBean deleteIngredient(@RequestBody List<Integer> list){
    // return ingredientService.deleteIngredientById(list);
    // }

    @PostMapping("/delete")
    public ResultBean deleteIngredientCategoryById(@RequestParam("id") Integer id) {
        return ingredientService.deleteIngredientById(id);
    }

}
