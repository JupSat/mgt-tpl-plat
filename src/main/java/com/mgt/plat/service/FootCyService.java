package com.mgt.plat.service;

import com.mgt.plat.entity.FootClassify;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

public interface FootCyService {
    ResultBean addFootCy(List<FootClassify> list);

    ResultBean findFootCyList(FootClassify footClassify);

    ResultBean updateFootCategoryByFootId(FootClassify footClassify);

    ResultBean deleteByFootCategoryById(List<Integer> list);
}
