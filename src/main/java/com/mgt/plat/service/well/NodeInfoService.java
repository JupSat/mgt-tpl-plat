package com.mgt.plat.service.well;

import com.mgt.plat.entity.well.NodeInfo;
import com.mgt.plat.entity.well.WellInfo;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

public interface NodeInfoService {
    ResultBean addNodeInfo(NodeInfo nodeInfo);

    ResultBean UpdateNodeInfo(NodeInfo nodeInfo);

    ResultBean<NodeInfo> findNodeInfoByName(NodeInfo nodeInfo);
}
