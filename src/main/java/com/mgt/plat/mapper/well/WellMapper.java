package com.mgt.plat.mapper.well;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.well.WellInfo;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface WellMapper extends BaseMapper<WellInfo> {
    List<WellInfo> findWellInfo();

    Integer addWellInfo();
}
