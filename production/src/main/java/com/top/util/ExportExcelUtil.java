/**
 * Copyright(c) Runsdata Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Runsdata
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Runsdata Technology Co.,Ltd.
 * For more information about Runsdata, welcome to http://www.runsdata.com
 * <p>
 * project: production
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/11/5 1.0          vae          Creation File
 */

package com.top.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description:
 * 导出数据到Excel表格
 * @author Super.vae
 * @date 2019/11/5 21:55
 */
public class ExportExcelUtil {

    public static String writeXLSXFile(Map<String, Object[]> data, String fileUrl, String fileName, String sheetName) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        Set<String> keyset = data.keySet();
        List<Integer> keyList = new ArrayList<>();
        for (String key : keyset) {
            if (key != null) {
                keyList.add(Integer.valueOf(key));
            }
        }
        Collections.sort(keyList);
        int rownum = 0;
        for (Integer key : keyList) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(String.valueOf(key));
            if (rownum == 1) {
                for (int i = 0; i < objArr.length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
                else if (obj instanceof LocalDateTime)
                    cell.setCellValue(obj.toString().replace("T", " "));
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Float) {
                    cell.setCellValue((Float) obj);
                } else if (obj instanceof BigDecimal) {
                    cell.setCellValue(obj.toString());
                }
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(fileUrl + "/" + fileName + ".xlsx"));
            workbook.write(out);
            out.close();
            //System.out.println(fileName + ".xls written successfully on disk.");
            return "/" + fileName + ".xlsx";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String writeXLSXFile2(Map<String, Object[]> data, String fileUrl, String fileName, String sheetName) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        XSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));

        CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 10);
        CellRangeAddress region4 = new CellRangeAddress(2, 2, (short) 0, (short) 4);
        CellRangeAddress region5 = new CellRangeAddress(2, 2, (short) 5, (short) 10);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region4);
        sheet.addMergedRegion(region5);


        Set<String> keyset = data.keySet();
        List<Integer> keyList = new ArrayList<>();
        for (String key : keyset) {
            if (key != null) {
                keyList.add(Integer.valueOf(key));
            }
        }
        Collections.sort(keyList);
        int rownum = 0;
        for (Integer key : keyList) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(String.valueOf(key));
            if (rownum == 1) {
                for (int i = 0; i < objArr.length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
                else if (obj instanceof LocalDateTime)
                    cell.setCellValue(obj.toString().replace("T", " "));
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Float) {
                    cell.setCellValue((Float) obj);
                } else if (obj instanceof BigDecimal) {
                    cell.setCellValue(obj.toString());
                }
            }
        }

        XSSFCellStyle celltyle = workbook.createCellStyle();
        celltyle.setAlignment(HorizontalAlignment.CENTER);
        sheet.getRow(0).getCell(0).setCellStyle(celltyle);
        XSSFCellStyle celltyle2 = workbook.createCellStyle();
        celltyle2.setAlignment(HorizontalAlignment.RIGHT);
        sheet.getRow(1).getCell(10).setCellStyle(celltyle2);
        try {

            FileOutputStream out = new FileOutputStream(new File(fileUrl + "/" + fileName + ".xlsx"));
            workbook.write(out);
            out.close();
            return "/" + fileName + ".xlsx";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

