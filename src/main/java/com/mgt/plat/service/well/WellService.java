package com.mgt.plat.service.well;

import com.mgt.plat.entity.well.WellInfo;
import com.mgt.plat.utils.ResultBean;

import java.util.List;

public interface WellService {

    List<WellInfo> findWellInfo();

    ResultBean addWellInfo(WellInfo wellInfo);
}
