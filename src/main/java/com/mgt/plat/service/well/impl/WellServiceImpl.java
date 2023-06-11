package com.mgt.plat.service.well.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgt.plat.entity.well.NodeInfo;
import com.mgt.plat.entity.well.WellInfo;
import com.mgt.plat.mapper.well.NodeInfoMapper;
import com.mgt.plat.mapper.well.WellMapper;
import com.mgt.plat.service.well.WellService;
import com.mgt.plat.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WellServiceImpl implements WellService {

    @Autowired
    private WellMapper wellMapper;

    @Autowired
    private NodeInfoMapper nodeInfoMapper;
    @Override
    public List<WellInfo> findWellInfo() {
        List<WellInfo> list = wellMapper.findWellInfo();
        list.stream().forEach(x->{
            List<NodeInfo> nodeInfo = nodeInfoMapper.selectBaNames(x.getWellId());
            x.setNodeInfoList(nodeInfo);

        });
        return list;
    }

    @Override
    public ResultBean addWellInfo(WellInfo wellInfo) {
        Integer result = wellMapper.addWellInfo();
        return null;
    }


}
