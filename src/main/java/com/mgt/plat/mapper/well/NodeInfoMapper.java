package com.mgt.plat.mapper.well;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.well.NodeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NodeInfoMapper extends BaseMapper<NodeInfo> {
   // Integer addNodeInfo(@Param("nodeInfo")NodeInfo nodeInfo);

    NodeInfo findNodeInfoByName(@Param("nodeId")String nodeId);

    List<NodeInfo> selectBaNames(@Param("wellId") String wellId);
}
