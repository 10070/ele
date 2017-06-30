package com.example.demo.service.impl;/**
 * Created by hand on 2017/6/24.
 */

import com.example.demo.conf.mail.SendMailProperties;
import com.example.demo.mapper.SiAdjustmentMapper;
import com.example.demo.model.SiAdjustment;
import com.example.demo.service.SiAdjustmentService;
import com.example.demo.util.MailUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 社保调整实现类
 *
 * @author zheng.zhang02@hand-china.com
 * @create 2017-06-24
 */

@Service
@Transactional
public class SiAdjustmentServiceImpl implements SiAdjustmentService {
    @Autowired
    private SiAdjustmentMapper siAdjustmentMapper;

    @Autowired
    private SendMailProperties sendMailProperties;

    @Override
    public SiAdjustment selectByPrimaryKey(Long adjustmentId) {
        return siAdjustmentMapper.selectSiAdjustmentByPrimaryKey(adjustmentId);
    }

    @Override
    public void generateExcel(HttpServletRequest request, HttpServletResponse response) {
        OutputStream outputStream = null;
        SXSSFWorkbook workbook = null;
        try {
            //设置响应编码
            response.addHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode("adjustment" + ".xlsx", "UTF-8") + "\"");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Accept-Ranges", "bytes");
            //设置响应输入流
            outputStream = response.getOutputStream();
            List<SiAdjustment> list = siAdjustmentMapper.selectAllSiAdjustments();
            workbook = generateSiAdjustmentExcel(list);
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            IOUtils.closeQuietly(outputStream);
        }
    }

    @Override
    public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<SiAdjustment> list = siAdjustmentMapper.selectAllSiAdjustments();
        SXSSFWorkbook workbook = generateSiAdjustmentExcel(list);
        String tempDir = System.getProperty("java.io.tmpdir");
        String fileName = "社保调整" + System.currentTimeMillis();
        String filePath = tempDir + File.separator + fileName + ".xlsx";
        OutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        IOUtils.closeQuietly(out);
        MailUtils mailUtils = new MailUtils(sendMailProperties.getFrom(), sendMailProperties.getPassword());
        mailUtils.setMailHost(sendMailProperties.getHost());//服务器地址
        mailUtils.setFrom(sendMailProperties.getFrom());//发件人
        mailUtils.setTo(sendMailProperties.getTo());//收件人
        mailUtils.setSubject(sendMailProperties.getSubject());
        mailUtils.setContent(sendMailProperties.getContent());
        List<String> attachements = new ArrayList<>();
        mailUtils.setCcs(mailUtils.strToList(sendMailProperties.getCcs()));//抄送人
        attachements.add(filePath);
        mailUtils.setAttachments(attachements);//附件
        mailUtils.sendMail();
        FileUtils.forceDelete(new File(filePath));
    }

    /**
     * 用来生成所有社保调整数据导出Excel
     *
     * @return
     */
    private SXSSFWorkbook generateSiAdjustmentExcel(List<SiAdjustment> list) {
        SXSSFWorkbook workbook = new SXSSFWorkbook();

        CellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);

        CellStyle sty = workbook.createCellStyle();
        sty.setAlignment(CellStyle.ALIGN_CENTER);
        sty.setBorderTop(CellStyle.BORDER_THIN);
        sty.setBorderBottom(CellStyle.BORDER_THIN);
        sty.setBorderLeft(CellStyle.BORDER_THIN);
        sty.setBorderRight(CellStyle.BORDER_THIN);

        Sheet sheet1 = workbook.createSheet("Sheet1");
        Row row = sheet1.createRow(1);

        Cell cell = row.createCell(1);
        cell.setCellValue("主键ID");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 1, 1));
        cell.setCellStyle(style);

        cell =  row.createCell(2);
        cell.setCellValue("档案ID");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 2, 2));
        cell.setCellStyle(style);

        cell =  row.createCell(3);
        cell.setCellValue("社保期间");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 3, 3));
        cell.setCellStyle(style);

        cell =  row.createCell(4);
        cell.setCellValue("生效期间");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 4, 4));
        cell.setCellStyle(style);

        cell =  row.createCell(5);
        cell.setCellValue("调整前");
        sheet1.addMergedRegion(new CellRangeAddress(1, 1, 5, 10));
        cell.setCellStyle(sty);

        cell =  row.createCell(11);
        cell.setCellValue("调整后");
        sheet1.addMergedRegion(new CellRangeAddress(1, 1, 11, 16));
        cell.setCellStyle(sty);

        cell =  row.createCell(17);
        cell.setCellValue("发送时间");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
        cell.setCellStyle(style);

        cell =  row.createCell(18);
        cell.setCellValue("是否发送");
        sheet1.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
        cell.setCellStyle(style);

        cell =  row.createCell(6);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(7);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(8);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(9);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(10);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(12);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(13);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(14);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(15);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);
        cell =  row.createCell(16);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        row = sheet1.createRow(2);

        cell =  row.createCell(5);
        cell.setCellValue("汇缴基数");
        cell.setCellStyle(style);

        cell =  row.createCell(6);
        cell.setCellValue("公积金基数");
        cell.setCellStyle(style);

        cell =  row.createCell(7);
        cell.setCellValue("补充公积金基数");
        cell.setCellStyle(style);

        cell =  row.createCell(8);
        cell.setCellValue("供应商ID");
        cell.setCellStyle(style);

        cell =  row.createCell(9);
        cell.setCellValue("缴纳城市");
        cell.setCellStyle(style);

        cell =  row.createCell(10);
        cell.setCellValue("全额缴纳");
        cell.setCellStyle(style);

        cell =  row.createCell(11);
        cell.setCellValue("汇缴基数");
        cell.setCellStyle(style);

        cell =  row.createCell(12);
        cell.setCellValue("公积金基数");
        cell.setCellStyle(style);

        cell =  row.createCell(13);
        cell.setCellValue("补充公积金基数");
        cell.setCellStyle(style);

        cell =  row.createCell(14);
        cell.setCellValue("供应商ID");
        cell.setCellStyle(style);

        cell =  row.createCell(15);
        cell.setCellValue("缴纳城市");
        cell.setCellStyle(style);

        cell =  row.createCell(16);
        cell.setCellValue("全额缴纳");
        cell.setCellStyle(style);


        cell =  row.createCell(1);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(2);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(3);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(4);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(17);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        cell =  row.createCell(18);
        cell.setCellType(Cell.CELL_TYPE_BLANK);
        cell.setCellStyle(style);

        int rowIndex = 3;
        for (SiAdjustment adjustment : list) {
            row = sheet1.createRow(rowIndex);

            cell =  row.createCell(1);
            cell.setCellValue(adjustment.getAdjustmentId());
            cell.setCellStyle(style);

            cell =  row.createCell(2);
            cell.setCellValue(adjustment.getSiArchiveId());
            cell.setCellStyle(style);

            cell =  row.createCell(3);
            cell.setCellValue(adjustment.getSiPeriod());
            cell.setCellStyle(style);

            cell =  row.createCell(4);
            cell.setCellValue(adjustment.getActivePeriodCode());
            cell.setCellStyle(style);

            cell =  row.createCell(5);
            if (adjustment.getBeforePaymentBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getBeforePaymentBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(6);
            if (adjustment.getBeforeHousingFundBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getBeforeHousingFundBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(7);
            if (adjustment.getBeforeHousingFundSupBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getBeforeHousingFundSupBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(8);
            cell.setCellValue(adjustment.getBeforeVendorId());
            cell.setCellStyle(style);

            cell =  row.createCell(9);
            cell.setCellValue(adjustment.getBeforeCityName());
            cell.setCellStyle(style);

            cell =  row.createCell(10);
            cell.setCellValue(adjustment.getBeforeFullyPaymentFlag());
            cell.setCellStyle(style);

            cell =  row.createCell(11);
            if (adjustment.getAfterPaymentBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getAfterPaymentBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(12);
            if (adjustment.getAfterHousingFundBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getAfterHousingFundBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(13);
            if (adjustment.getAfterHousingFundSupBase() != null) {
                cell.setCellValue(String.format("%.2f", adjustment.getAfterHousingFundSupBase().doubleValue()));
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(style);

            cell =  row.createCell(14);
            cell.setCellValue(adjustment.getAfterVendorId());
            cell.setCellStyle(style);

            cell =  row.createCell(15);
            cell.setCellValue(adjustment.getAfterCityName());
            cell.setCellStyle(style);

            cell =  row.createCell(16);
            cell.setCellValue(adjustment.getAfterFullyPaymentFlag());
            cell.setCellStyle(style);

            cell =  row.createCell(17);
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
            sheet1.setColumnWidth(17, 2800);
            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);

            if (adjustment.getSendedDate() != null) {
                cell.setCellValue(adjustment.getSendedDate());
            } else {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
            }
            cell.setCellStyle(cellStyle);

            cell =  row.createCell(18);
            cell.setCellValue(adjustment.getSendedFlag());
            cell.setCellStyle(style);

            rowIndex++;
        }
        return workbook;
    }
}
