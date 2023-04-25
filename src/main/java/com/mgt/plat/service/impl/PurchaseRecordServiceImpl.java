package com.mgt.plat.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.mapper.PurchaseRecordMapper;
import com.mgt.plat.service.PurchaseRecordService;
import com.mgt.plat.utils.ExcelExportBean;
import com.mgt.plat.utils.ResultBean;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * package name：com.mgt.plat.service.impl
 * description：
 * user：JupSat
 * modification time：2023-02-05 20:57
 * modified content：
 **/
@Service
 public class PurchaseRecordServiceImpl implements PurchaseRecordService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseRecordServiceImpl.class);
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    public ResultBean<T> insertPurchaseRecord(List<PurchaseRecord> purchaseRecord) {
        try {
            purchaseRecordMapper.addPurchaseRcd(purchaseRecord);
            System.out.print(purchaseRecord);
            return  ResultBean.success("新增成功");
        }catch (Exception e){
            logger.error("新增失败!", e);
        }
        return  ResultBean.error("新增失败!");
     }

    @Override
    public ResultBean<T> deletePurchaseRecord(Integer id) {
        try {
            Integer type = purchaseRecordMapper.deletePurchaseRcdById(id);
            if (type>0){
                return ResultBean.success("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.error("删除失败!");
        }
        return ResultBean.error("无效ID!");
    }

    @Override
    public ResultBean<T> updatePurchaseRecord(PurchaseRecord purchaseRecord) {
        try {
            Integer type = purchaseRecordMapper.updatePurchaseRcdById(purchaseRecord);
            if (type==1){
                return ResultBean.success("数据更新成功");
            }
        }catch (Exception e){
            logger.error("更新失败!", e);
            return ResultBean.error("更新失败");
        }
        return  ResultBean.error("更新失败!");
    }

    @Override
    public ResultBean<List<PurchaseRecord>> findPurchaseRecordList(String ingredientId, String purchaseDate) {
        try{
            int tempIngredientId;
            if (ingredientId == null || ingredientId.equals("")) {
                tempIngredientId = 0;
            } else {
                tempIngredientId = Integer.parseInt(ingredientId);
            }
            List<PurchaseRecord> purchaseRecordList = purchaseRecordMapper.findPurchaseRcdList(tempIngredientId, purchaseDate);
            if (purchaseRecordList.size()>0){
                return ResultBean.success("查询成功!",purchaseRecordList);
            }else{
                return ResultBean.error("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.error("查询失败!");
        }
    }

    @Override
    public ResultBean<IPage<PurchaseRecord>> findPurchaseRecordListByPage(String ingredientId, String purchaseDate, Integer pageSize, Integer pageNum) {
        try{
            int tempIngredientId;
            if (ingredientId == null || ingredientId.equals("")) {
                tempIngredientId = 0;
            } else {
                tempIngredientId = Integer.parseInt(ingredientId);
            }
            Page<PurchaseRecord> page = new Page<>(pageNum, pageSize);
            IPage<PurchaseRecord> purchaseRecordList =
                 purchaseRecordMapper.findPurchaseRcdListByPage(page,tempIngredientId, purchaseDate);
//            List<PurchaseRecord> purchaseRecordList =
//                    purchaseRecordMapper.findPurchaseRcdListByPage(tempIngredientId, purchaseDate, pageSize, pageNum);
            if (purchaseRecordList != null){
                return ResultBean.success("查询成功!",purchaseRecordList);
            }else{
                return ResultBean.error("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.error("查询失败!");
        }
    }

    @Resource
    private ExcelExportBean excelExportBean;
    @Override
    public void exportPurchaseRecordFile(HttpServletResponse response) {
        try{
            List<PurchaseRecord> purchaseRecordList = purchaseRecordMapper.findPurchaseRcdList(null,null);
            excelExportBean.export(response,  "采购记录_" + System.currentTimeMillis(), purchaseRecordList, PurchaseRecord.class);
         }catch (Exception e){
             logger.error("系统异常!", e);
        }
    }

    @Override
    public ResultBean<T> findPurchaseRecordById(Integer number) {
        return null;
    }
}
