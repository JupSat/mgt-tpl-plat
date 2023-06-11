package com.mgt.plat.service.well.impl;

import cn.hutool.core.date.DateUtil;
import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mgt.plat.entity.well.NodeInfo;
import com.mgt.plat.mapper.well.NodeInfoMapper;
import com.mgt.plat.service.well.NodeInfoService;
import com.mgt.plat.utils.IdGenUtils;
import com.mgt.plat.utils.ResultBean;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class NodeInfoServiceImpl extends ServiceImpl<NodeInfoMapper,NodeInfo> implements NodeInfoService {
    @Autowired
    private NodeInfoMapper nodeInfoMapper;
    @Override
    public ResultBean addNodeInfo(NodeInfo nodeInfo) {
        UUID uuid = UUID.randomUUID();
        nodeInfo.setNodeId(IdGenUtils.getId());
        nodeInfo.setNodeCreate(DateUtil.now());
        nodeInfo.setNodeUpdate(DateUtil.now());
        Integer num = nodeInfoMapper.addNodeInfo(nodeInfo);
        if (num==1){
            return ResultBean.success("新增成功!",true);
        }
        return ResultBean.error("新增失败!");

    }

    @Override
    public ResultBean UpdateNodeInfo(NodeInfo nodeInfo) {
        Integer num = nodeInfoMapper.updateById(nodeInfo);
        if (num==1){
            return ResultBean.success("修改成功!",true);
        }
        return ResultBean.error("修改失败!");
    }

    @Override
    public ResultBean<NodeInfo> findNodeInfoByName(NodeInfo nodeInfo) {
        NodeInfo info = nodeInfoMapper.findNodeInfoByName(nodeInfo);
        if (info==null) {
            return ResultBean.error("节点信息不存在");
        }
        return ResultBean.success("请求成功!",info);

    }
}
