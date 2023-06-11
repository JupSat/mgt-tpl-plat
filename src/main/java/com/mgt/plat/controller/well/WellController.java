package com.mgt.plat.controller.well;

import com.mgt.plat.entity.well.WellInfo;
import com.mgt.plat.service.well.WellService;
import com.mgt.plat.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/well")
public class WellController {

    @Autowired
    private WellService wellService;

    @PostMapping("/find")
    public ResultBean<List> findWellInfo(){
        List<WellInfo> wellInfos = wellService.findWellInfo();
        return ResultBean.success("请求成功",wellInfos);
    }

}
