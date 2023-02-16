package com.mgt.plat.utils;

import com.alibaba.excel.EasyExcel;
import com.mgt.plat.entity.PurchaseRecord;
import com.mgt.plat.mapper.BatchInsertMapper;
import com.mgt.plat.mapper.PurchaseRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：AlexDU
 * modification time：2023-02-14 17:30
 * modified content：
 **/
@Slf4j
@Component
public class ExcelComponent {
    @Resource
    private PurchaseRecordMapper purchaseRecordMapper;

    /**
     * Excel文件分批导入数据库
     * @param file 上传的文件
     * @throws IOException 读取文件异常
     */
    public ResultBean importPurchaseRecordFile(MultipartFile file) throws IOException {
          try{
              EasyExcel.read(file.getInputStream())
                      .head(PurchaseRecord.class)
                      .registerReadListener(new ExcelImportListener<PurchaseRecord>() {
                          @Override
                          protected BatchInsertMapper<PurchaseRecord> getMapper() {
                              return purchaseRecordMapper;
                          }
                      }).sheet().doRead();
              return ResultBean.ok("导入成功!", null);
          } catch (Exception e) {
                e.printStackTrace();
                log.error("导入失败" + e.getMessage());
                throw new RuntimeException("导入失败", e);
          }
    }
}
