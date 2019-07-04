package cn.thght.swj.workbook.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.thght.swj.workbook.mode.ResultData;
import lombok.extern.log4j.Log4j;

/**
 * 写入Excel
 * 
 * @author 作者: thght
 * @version 创建时间: 2018年7月1日
 */
@Log4j
public class ExcelWriteUtils {
    private static HSSFWorkbook workbook = null;

    private ExcelWriteUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 判断文件是否存在
     * 
     * @param fileDir
     * @return
     */
    public static boolean fileExist(String fileDir) {
        boolean flag = false;
        File file = new File(fileDir);
        flag = file.exists();
        return flag;
    }

    /**
     * 判断文件的sheet是否存在
     * 
     * @param fileDir
     * @param sheetName
     * @return
     * @throws Exception
     */
    public static boolean sheetExist(String fileDir, String sheetName) throws Exception {
        File file = new File(fileDir);
        return sheetExist(sheetName, file);
    }

    /**
     * 判断文件的sheet是否存在
     * 
     * @param sheetName
     * @param file
     * @return
     * @throws Exception
     */
    public static boolean sheetExist(String sheetName, File file) throws Exception {
        boolean flag = false;
        if (file.exists()) {
            try {
                workbook = new HSSFWorkbook(new FileInputStream(file));

                HSSFSheet sheet = workbook.getSheet(sheetName);

                if (sheet != null) {
                    flag = true;
                }

            } catch (Exception e) {
                throw e;
            }
        }
        return flag;
    }

    /**
     * 创建文件
     * 
     * @param fileDir
     * @param sheetName
     * @param titleRow
     * @throws Exception
     */
    public static void createExcel(String fileDir, String sheetName, String titleRow[]) throws Exception {
        // 创建workbook
        workbook = new HSSFWorkbook();

        // 添加worksheet
        HSSFSheet sheet1 = workbook.createSheet(sheetName);
        // 新建文件
        try (FileOutputStream out = new FileOutputStream(fileDir)) {
            // 添加表头
            HSSFRow row = sheet1.createRow(0);
            for (short i = 0; i < titleRow.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(titleRow[i]);
            }

            workbook.write(out);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 创建文件
     * 
     * @param fileDir
     * @param sheetName
     * @throws Exception
     */
    public static void createExcel(File file, String sheetName) throws Exception {
        // 创建workbook
        workbook = new HSSFWorkbook();

        // 添加worksheet
        HSSFSheet sheet1 = workbook.createSheet(sheetName);
        // 新建文件
        try (FileOutputStream out = new FileOutputStream(file)) {
            // 添加表头
            HSSFRow row = sheet1.createRow(0);
            for (ResultDataExcelKeysEnum rdeke : ResultDataExcelKeysEnum.values()) {
                HSSFCell cell = row.createCell(rdeke.getIndex());
                cell.setCellValue(rdeke.getColumnname());
            }

            workbook.write(out);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 写入内容
     * 
     * @throws Exception
     */
    public static void writeToExcel(String fileDir, String sheetName, List<ResultData> resultDataList)
            throws Exception {
        // 创建workbook
        File file = new File(fileDir);
        writeToExcel(sheetName, resultDataList, file);
    }

    /**
     * 写入内容
     * 
     * @throws Exception
     */
    public static void writeToExcel(String sheetName, List<ResultData> resultDataList, File file) throws Exception {
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            log.error("context", e);
        } catch (IOException e) {
            log.error("message", e);
        }

        HSSFSheet sheet = workbook.getSheet(sheetName);

        ResultData rd;
        HSSFRow newRow;
        HSSFCell cell;
        try (FileOutputStream out = new FileOutputStream(file)) {
            // 获得表头对象
            HSSFRow titleRow = sheet.getRow(0);
            if (titleRow != null) {
                for (int rowId = 0; rowId < resultDataList.size(); rowId++) {
                    rd = resultDataList.get(rowId);
                    newRow = sheet.createRow(rowId + 1);
                    for (ResultDataExcelKeysEnum rdeke : ResultDataExcelKeysEnum.values()) {
                        cell = newRow.createCell(rdeke.getIndex());
                        rdeke.setField(rd, cell);
                    }

                }
            }
            workbook.write(out);
        } catch (Exception e) {
            throw e;
        }
    }

}
