package com.mgt.plat.controller.well;

import com.mgt.plat.entity.well.NodeInfo;
import com.mgt.plat.service.well.NodeInfoService;
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
@RequestMapping("/node")
public class NodeInfoController {
    @Autowired
    private NodeInfoService nodeInfoService;
    @PostMapping("/add")
    public ResultBean<List> addNodeInfo(@RequestBody NodeInfo nodeInfo){
        return nodeInfoService.addNodeInfo(nodeInfo);
    }

    @PostMapping("/update")
    public ResultBean<List> UpdateNodeInfo(@RequestBody NodeInfo nodeInfo){
        return nodeInfoService.UpdateNodeInfo(nodeInfo);
    }

    @PostMapping("/find")
    public ResultBean<NodeInfo> getNodeInfoByName(@RequestBody NodeInfo nodeInfo){
        return nodeInfoService.findNodeInfoByName(nodeInfo);
    }

}
