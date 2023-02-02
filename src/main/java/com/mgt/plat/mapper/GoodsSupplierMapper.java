package com.mgt.plat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * package name：com.mgt.plat.mapper
 * description：
 * user：lglhope
 * modification time：2023-02-02 15:35
 * modified content：
 **/
@Mapper
public interface GoodsSupplierMapper extends BaseMapper<GoodsSupplier> {

    User querySupplierById(String id);

    User querySupplierByName(@Param("username") String username);

    @Update("update goods_supplier g set g.address = #{address},g.contact = #{contact},g.phone = #{phone},g.email = #{email},g.remarks = #{remarks}," +
            " where g.id = #{id}")
    int updateById(GoodsSupplier goodsSupplier);

    /**
     * 批量插入数据
     * @param goodsSupplierList
     */
    void batchInsertData(@Param("list") List<GoodsSupplier> goodsSupplierList);

}