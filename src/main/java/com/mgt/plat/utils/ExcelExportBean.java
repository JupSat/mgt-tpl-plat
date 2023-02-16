package com.mgt.plat.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2023-02-14 17:33
 * modified content：
 **/
@Slf4j
@Component
public class ExcelExportBean {
    /**
     * 下载Excel格式的数据
     *
     * @param response response
     * @param fileName 文件名（支持中文）
     * @param data     待下载的数据
     * @param clazz    封装数据的POJO
     * @param <T>      数据泛型
     */
    public <T> ResultBean export(HttpServletResponse response, String fileName,
                           List<T> data, Class<T> clazz) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            // URLEncoder.encode防止中文乱码
            String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename*=utf-8''" + encodedFileName + ".xlsx");
            // 设置不关闭流
            EasyExcel.write(response.getOutputStream(), clazz)
                    .sheet("Sheet1")
                    // 设置单元格宽度自适应
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    // 自定义设置策略
                    .registerWriteHandler(getHorizontalCellStyleStrategy())
                    .doWrite(data);
            log.info("下载{}条记录到文件{}", data.size(), fileName);
            return ResultBean.ok("下载成功！");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件下载失败" + e.getMessage());
//            throw new RuntimeException("下载文件失败", e);
            return ResultBean.error("下载失败！");
        }

    }

    /**
     * 设置Excel导出策略
     * 表头及内容属性等设置
     * @return Excel导出策略
     */
    private HorizontalCellStyleStrategy getHorizontalCellStyleStrategy() {
        /*表头策略*/
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //1.背景颜色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());

        //2.设置字体属性
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);
        headWriteFont.setBold(true);

        /*内容策略*/
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        //自动换行
        contentWriteCellStyle.setWrapped(true);
        //垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }
}
