package com.mgt.plat.controller;

import com.mgt.plat.entity.FootClassify;
import com.mgt.plat.service.FootCyService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 食品分类ctrl
 */
@RestController
@RequestMapping("/foot")
public class FootCyController {
    @Autowired
    private FootCyService footCyService;

    @PostMapping("/add")
    public ResultBean addFootCy(@RequestBody List<FootClassify> footClassify){
        return footCyService.addFootCy(footClassify);
    }
    /**
     * 查询食品分类
     */
    @PostMapping("/find")
    public ResultBean findFootCyList(@RequestBody FootClassify footClassify){
        return footCyService.findFootCyList(footClassify);
    }
    @PostMapping("/update")
    public ResultBean updateFootCategory(@RequestBody FootClassify footClassify){
        return footCyService.updateFootCategoryByFootId(footClassify);
    }
    @PostMapping("/delete")
    public ResultBean deleteByFootCategory(@RequestBody List<Integer> list){
        return footCyService.deleteByFootCategoryById(list);
    }
}
