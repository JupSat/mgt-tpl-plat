package com.mgt.plat.mapper.well;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.well.NodeInfo;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NodeInfoMapper extends BaseMapper<NodeInfo> {
    Integer addNodeInfo(@Param("nodeInfo")NodeInfo nodeInfo);

    NodeInfo findNodeInfoByName(@Param("nodeInfo")NodeInfo nodeInfo);

    Integer updateByIds(NodeInfo nodeInfo);

    List<NodeInfo> selectBaNames(@Param("wellId") String wellId);
}
