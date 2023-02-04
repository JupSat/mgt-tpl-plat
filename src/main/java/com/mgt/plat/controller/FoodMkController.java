package com.mgt.plat.controller;

import com.mgt.plat.entity.FoodMonicker;
import com.mgt.plat.service.FoodMkService;
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
@RequestMapping("/monicker")
public class FoodMkController {
    @Autowired
    private FoodMkService foodMkService;

    @PostMapping("/add")
    public ResultBean insertFoodMonicker(@RequestBody List<FoodMonicker> list){
        return foodMkService.insertFoodMonicker(list);
    }
    @GetMapping("/find")
    public ResultBean findMonicke(@RequestParam Integer number){
        return foodMkService.findMonickerById(number);
    }
    @PostMapping("/update")
    public ResultBean updateFoodMonicker(@RequestBody FoodMonicker foodMonicker){
        foodMkService.updateFoodMonickerByFoodId(foodMonicker);
        return foodMkService.updateFoodMonickerByFoodId(foodMonicker);
    }
    @PostMapping("delete")
    public ResultBean deleteFoodMonicker(@RequestBody List<Integer> list){
        return foodMkService.deleteFoodMonickerById(list);
    }

}
