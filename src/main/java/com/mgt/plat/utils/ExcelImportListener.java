package com.mgt.plat.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.mgt.plat.mapper.BatchInsertMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2023-02-14 17:28
 * modified content：
 **/
@Slf4j
public abstract class ExcelImportListener<T> implements ReadListener<T> {
    /**
     * 缓存大小
     */
    private static final int BATCH_SIZE = 100;

    /**
     * 缓存数据
     */
    private List<T> cacheList = new ArrayList<>(BATCH_SIZE);

    @Override
    public void invoke(T po, AnalysisContext analysisContext) {
        cacheList.add(po);
        if (cacheList.size() >= BATCH_SIZE) {
            log.info("完成一批Excel记录的导入，条数为：{}", cacheList.size());
            getMapper().batchInsert(cacheList);
            cacheList = new ArrayList<>(BATCH_SIZE);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        getMapper().batchInsert(cacheList);
        log.info("完成最后一批Excel记录的导入，条数为：{}", cacheList.size());
    }

    /**
     * 获取批量插入的Mapper
     * @return 批量插入的Mapper
     */
    protected abstract BatchInsertMapper<T> getMapper();
}
