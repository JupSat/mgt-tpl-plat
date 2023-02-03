package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.FootClassify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FootCyMapper extends BaseMapper<FootClassify> {
    void addFoodCy(List<FootClassify> list);

    List<FootClassify> findFootCyList(FootClassify footClassify);

    Integer updateFootCategoryByFootId(FootClassify footClassify);

    Integer deleteByFootCategoryById(List<Integer> list);
}
