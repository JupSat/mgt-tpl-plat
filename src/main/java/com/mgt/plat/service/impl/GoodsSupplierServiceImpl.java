package com.mgt.plat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mgt.plat.entity.FoodMonicker;
import com.mgt.plat.entity.GoodsSupplier;
import com.mgt.plat.mapper.GoodsSupplierMapper;
import com.mgt.plat.service.GoodsSupplierService;
import com.mgt.plat.utils.ResultBean;
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
    private final static Logger logger = LoggerFactory.getLogger(FoodCyServiceImpl.class);

    @Autowired
    private GoodsSupplierMapper goodsSupplierMapper;

    @Override
    public ResultBean addSupplier(GoodsSupplier goodsSupplier) {
        try {
            int num = goodsSupplierMapper.insert(goodsSupplier);;
            if (num>0){
                return ResultBean.ok("新增成功!",true);
            }
        }catch (Exception e){
//            e.printStackTrace();
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！",false);
        }

        return ResultBean.ok("新增失败!",false);
    }

    @Override
    public ResultBean batchAddSupplier(List<GoodsSupplier> goodsSupplierList) {
//        goodsSupplierMapper.batchInsertData(goodsSupplierList);
//       return this.saveOrUpdateBatch(goodsSupplierList);
        return null;
    }

    @Override
    public ResultBean findByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
//        return goodsSupplierMapper.selectList(wrapper).stream().findFirst().orElse(null);
        return null;
    }
    @Override
    public ResultBean findById(String id) {
//        return goodsSupplierMapper.querySupplierById(id);
          return  null;
    }

    @Override
    public ResultBean findAllByName(String name) {
        QueryWrapper<GoodsSupplier> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        try{
            List<GoodsSupplier> list = goodsSupplierMapper.selectList(wrapper);
            if (list.size()>0){
                return ResultBean.ok("查询成功！",list);
            }
        }catch (Exception e){
            logger.error("系统异常!", e);
            return ResultBean.ok("系统异常！",null);
        }
        return ResultBean.ok("您查找的内容不存在！",null);
    }

    @Override
    public ResultBean updateSupplier(GoodsSupplier goodsSupplier) {
        try{
            int flag = goodsSupplierMapper.updateById(goodsSupplier);
            if (flag > 0){
                return ResultBean.ok("修改成功!","success");
            }
        } catch (Exception e){
            logger.error("系统异常!",e);
            return ResultBean.ok("系统异常！","error");
        }
        return ResultBean.ok("修改失败，请检查字段合法性!","error");
    }

    @Override
    public ResultBean deleteById(Long id) {
         try {
            int num = goodsSupplierMapper.deleteById(id);
            if (num>0){
                return ResultBean.ok("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.ok("删除失败!");
        }
        return ResultBean.ok("无效ID!");
    }

}
