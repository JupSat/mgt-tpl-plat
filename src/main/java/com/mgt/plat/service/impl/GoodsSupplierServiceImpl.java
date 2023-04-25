package com.mgt.plat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.mapper.GoodsSupplierMapper;
import com.mgt.plat.service.GoodsSupplierService;
import com.mgt.plat.utils.ResultBean;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * package name：com.mgt.plat.service
 * description：
 * user：lglhope
 * modification time：2023-02-02 19:45
 * modified content：
 **/
@Service
public class GoodsSupplierServiceImpl extends ServiceImpl<GoodsSupplierMapper, GoodsSupplier> implements GoodsSupplierService {
    private final static Logger logger = LoggerFactory.getLogger(IngredientCatalogServiceImpl.class);

    @Autowired
    private GoodsSupplierMapper goodsSupplierMapper;

    @Override
    public ResultBean<T> addSupplier(GoodsSupplier goodsSupplier) {
        try {
            QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
            wrapper.eq("name", goodsSupplier.getName());
            GoodsSupplier gs = goodsSupplierMapper.selectOne(wrapper);
            if (gs == null) {
                int num = goodsSupplierMapper.insert(goodsSupplier);;
                if (num>0){
                    return ResultBean.success("新增成功!");
                }
            }  else {
                return ResultBean.error(goodsSupplier.getName() + "已存在!");
            }
        }catch (Exception e){
//            e.printStackTrace();
            logger.error("系统异常!", e);
            return ResultBean.error("系统异常！");
        }

        return ResultBean.error("新增失败!");
    }

    @Override
    public ResultBean<T> batchAddSupplier(List<GoodsSupplier> goodsSupplierList) {
//        goodsSupplierMapper.batchInsertData(goodsSupplierList);
//       return this.saveOrUpdateBatch(goodsSupplierList);
        return null;
    }

    @Override
    public ResultBean<T> findByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
//        return goodsSupplierMapper.selectList(wrapper).stream().findFirst().orElse(null);
        return null;
    }
    @Override
    public ResultBean<T> findById(String id) {
//        return goodsSupplierMapper.querySupplierById(id);
          return  null;
    }

    @Override
    public ResultBean<List<GoodsSupplier>> findAllByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        try{
            List<GoodsSupplier> list = goodsSupplierMapper.selectList(wrapper);
            if (list.size()>0){
                return ResultBean.success("查询成功！",list);
            }
        }catch (Exception e){
            logger.error("系统异常!", e);
            return ResultBean.error("系统异常！" );
        }
        return ResultBean.error("您查找的内容不存在！" );
    }

    @Override
    public ResultBean<T> updateSupplier(GoodsSupplier goodsSupplier) {
        try{
            int flag = goodsSupplierMapper.updateById(goodsSupplier);
            if (flag > 0){
                return ResultBean.success("修改成功!");
            }
        } catch (Exception e){
            logger.error("系统异常!",e);
            return ResultBean.error("系统异常！");
        }
        return ResultBean.error("修改失败，请检查字段合法性!");
    }

    @Override
    public ResultBean<T> deleteById(Long id) {
         try {
            int num = goodsSupplierMapper.deleteById(id);
            if (num>0){
                return ResultBean.success("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.error("删除失败!");
        }
        return ResultBean.error("无效ID!");
    }

}
