package com.mgt.plat.mapper;

import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：
 * user：JupSat
 * modification time：2023-02-14 17:21
 * modified content：
 **/
public interface BatchInsertMapper<T> {
    void batchInsert(List<T> list);
}
