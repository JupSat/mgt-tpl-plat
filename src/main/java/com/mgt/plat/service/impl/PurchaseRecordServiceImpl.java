package com.mgt.plat.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.mapper.PurchaseRecordMapper;
import com.mgt.plat.service.PurchaseRecordService;
import com.mgt.plat.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public ResultBean insertPurchaseRecord(List<PurchaseRecord> purchaseRecord) {
        try {
            purchaseRecordMapper.addPurchaseRcd(purchaseRecord);
            System.out.print(purchaseRecord);
            return  ResultBean.ok("新增成功");
        }catch (Exception e){
            logger.error("新增失败!", e);
        }
        return  ResultBean.ok("新增失败!");
     }

    @Override
    public ResultBean deletePurchaseRecord(Integer id) {
        try {
            Integer type = purchaseRecordMapper.deletePurchaseRcdById(id);
            if (type>0){
                return ResultBean.ok("删除成功!");
            }
        }catch (Exception e){
            logger.error("删除失败!", e);
            return ResultBean.ok("删除失败!");
        }
        return ResultBean.ok("无效ID!");
    }

    @Override
    public ResultBean updatePurchaseRecord(PurchaseRecord purchaseRecord) {
        try {
            Integer type = purchaseRecordMapper.updatePurchaseRcdById(purchaseRecord);
            if (type==1){
                return ResultBean.ok("数据更新成功");
            }
        }catch (Exception e){
            logger.error("更新失败!", e);
            return ResultBean.ok("更新失败");
        }
        return  ResultBean.ok("更新失败!");
    }

    @Override
    public ResultBean findPurchaseRecordList(String ingredientId, String purchaseDate) {
        try{
            int tempIngredientId;
            if (ingredientId == null || ingredientId.equals("")) {
                tempIngredientId = 0;
            } else {
                tempIngredientId = Integer.parseInt(ingredientId);
            }
            List<PurchaseRecord> purchaseRecordList = purchaseRecordMapper.findPurchaseRcdList(tempIngredientId, purchaseDate);
            if (purchaseRecordList.size()>0){
                return ResultBean.ok("查询成功!",purchaseRecordList);
            }else{
                return ResultBean.ok("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean findPurchaseRecordListByPage(String ingredientId, String purchaseDate, Integer pageSize, Integer pageNum) {
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
                return ResultBean.ok("查询成功!",purchaseRecordList);
            }else{
                return ResultBean.ok("您查询的数据不存在!");
            }
        }catch (Exception e){
            return ResultBean.ok("查询失败!");
        }
    }

    @Override
    public ResultBean findPurchaseRecordById(Integer number) {
        return null;
    }
}
