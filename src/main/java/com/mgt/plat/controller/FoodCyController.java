package com.mgt.plat.controller;

import com.mgt.plat.entity.FoodClassify;
import com.mgt.plat.service.FoodCyService;
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
@RequestMapping("/food")
public class FoodCyController {
    @Autowired
    private FoodCyService foodCyService;

    @PostMapping("/add")
    public ResultBean addFoodCy(@RequestBody List<FoodClassify> foodClassify){
        return foodCyService.addFoodCy(foodClassify);
    }
    /**
     * 查询食品分类
     */
    @PostMapping("/find")
    public ResultBean findFoodCyList(@RequestBody FoodClassify foodClassify){
        return foodCyService.findFoodCyList(foodClassify);
    }
    @PostMapping("/update")
    public ResultBean updateFoodCategory(@RequestBody FoodClassify foodClassify){
        foodCyService.updateFoodCategoryByFoodId(foodClassify);
        return foodCyService.updateFoodCategoryByFoodId(foodClassify);
    }
//    @PostMapping("/delete")
//    public ResultBean deleteByFoodCategory(@RequestBody List<Integer> list){
//        return foodCyService.deleteByFoodCategoryById(list);
//    }

    @PostMapping("/delete")
    public ResultBean deleteIngredientCategoryById(@RequestParam("id") Integer id){
        return foodCyService.deleteIngredientCategoryById(id);
    }
    @GetMapping("/exists")
    public ResultBean findCategory(@RequestParam String category){
        foodCyService.findCategoryExists(category);
        return foodCyService.findCategoryExists(category);
    }
}
