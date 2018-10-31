package cn.thght.swj.workbook.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.activity.InvalidActivityException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.util.StringUtils;

import cn.thght.swj.workbook.mode.ActionData;
import cn.thght.swj.workbook.mode.ResultData;
import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;
import cn.thght.swj.workbook.utils.dateformat.DateFormatUtils;
import lombok.extern.log4j.Log4j;

/**
 * 春风版的简化版, 针对导入分数的模板Excel进行解析
 * 
 * @author tHgHt-xueXi
 *
 */
@Log4j
public class ExcelReadUtils {

    /**
     * 根据模板转化
     * 
     * @param inputStream
     * @param compeId
     * @param compeAreaId
     * @param gradeId
     * @return
     * @throws EncryptedDocumentException
     * @throws ExcelAnalysisException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<ActionData> readExcel(InputStream inputStream, String compeId, String compeAreaId,
            String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        return readExcel(workbook, compeId, compeAreaId, gradeId);
    }

    /**
     * 根据模块化
     * 
     * @param inputStream
     * @param compeId
     * @param gradeId
     * @return
     * @throws EncryptedDocumentException
     * @throws ExcelAnalysisException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<ActionData> readExcel(InputStream inputStream, String compeId, String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        return readExcel(workbook, compeId, gradeId);
    }

    /**
     * 根据模板转化
     * 
     * @param fileInputStream
     * @param compeId
     * @param compeAreaId
     * @param gradeId
     * @return
     * @throws EncryptedDocumentException
     * @throws ExcelAnalysisException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<ActionData> readExcel(FileInputStream fileInputStream, String compeId, String compeAreaId,
            String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        return readExcel(workbook, compeId, compeAreaId, gradeId);
    }

    /**
     * 根据模板转化
     * 
     * @param fileInputStream
     * @param compeId
     * @param gradeId
     * @return
     * @throws EncryptedDocumentException
     * @throws ExcelAnalysisException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<ActionData> readExcel(FileInputStream fileInputStream, String compeId, String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        return readExcel(workbook, compeId, gradeId);
    }

    /**
     * 根据模板转化
     * 
     * @param inputStream
     * @return
     * @throws EncryptedDocumentException
     * @throws ExcelAnalysisException
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<ActionData> readExcel(InputStream inputStream)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        return readExcel(workbook);
    }

    private static List<ActionData> readExcel(Workbook workbook)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Sheet sheet = workbook.getSheetAt(0);
        MaxRowColumnNum mxrcn = new MaxRowColumnNum(sheet);
        if (mxrcn.getMaxColumnNum() < ActionDataExcelKeysEnum.MAX_COLUMN_NUM) {
            throw new ExcelAnalysisException("最大列数小于需求列数");
        }
        LinkedList<ActionData> actionDataList = new LinkedList<ActionData>();
        // 逐行解读
        Row row = null;
        String value = null;
        for (int rowNum = 1; rowNum <= mxrcn.getMaxRowNum(); rowNum++) {
            row = sheet.getRow(rowNum);
            if (row != null) {
                actionDataList.add(new ActionData());
                for (ActionDataExcelKeysEnum eKey : ActionDataExcelKeysEnum.values()) {
                    Cell cell = row.getCell(eKey.getIndex());

                    if (cell == null) {
                        value = null;
                    } else {
                        value = getValue(eKey, cell);
                    }
                    ActionDataExcelKeysEnum.setField(actionDataList.getLast(), eKey, value);
                }
                if (StringUtils.isEmpty(actionDataList.getLast().getName())) {
                    actionDataList.removeLast();
                }
            }
        }

        return actionDataList;

    }

    /**
     * @param eKey
     * @param cell
     * @return
     */
    private static String getValue(ActionDataExcelKeysEnum eKey, Cell cell) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_NUMERIC:
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                return DateFormatUtils.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()),
                        DateFormatTypeEnum.FIVE);
            } else {
                return ResultData.FORMAT.format(cell.getNumericCellValue());
            }
        case Cell.CELL_TYPE_FORMULA:
            try {
                return String.valueOf(cell.getNumericCellValue());
            } catch (IllegalStateException e) {
                return String.valueOf(cell.getRichStringCellValue());
            }

        default:
            return cell.toString();
        }

    }

    private static List<ActionData> readExcel(Workbook workbook, String compeId, String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Sheet sheet = workbook.getSheetAt(0);
        MaxRowColumnNum mxrcn = new MaxRowColumnNum(sheet);
        if (mxrcn.getMaxColumnNum() < ActionDataExcelKeysEnum.MAX_COLUMN_NUM) {
            throw new ExcelAnalysisException("最大列数小于需求列数");
        }
        LinkedList<ActionData> examineeAchievementsList = new LinkedList<>();
        // 逐行解读
        Row row = null;
        String value = null;
        for (int rowNum = 1; rowNum <= mxrcn.getMaxRowNum(); rowNum++) {
            row = sheet.getRow(rowNum);
            if (row != null) {
                examineeAchievementsList.add(new ActionData());
                for (ActionDataExcelKeysEnum eKey : ActionDataExcelKeysEnum.values()) {
                    Cell cell = row.getCell(eKey.getIndex());

                    if (cell == null) {
                        value = null;
                    } else {
                        value = getValue(eKey, cell);
                    }
                    ActionDataExcelKeysEnum.setField(examineeAchievementsList.getLast(), eKey, value);
                }
            }
        }

        return examineeAchievementsList;

    }

    private static List<ActionData> readExcel(Workbook workbook, String compeId, String compeAreaId, String gradeId)
            throws EncryptedDocumentException, ExcelAnalysisException, InvalidFormatException, IOException {
        Sheet sheet = workbook.getSheetAt(0);
        MaxRowColumnNum mxrcn = new MaxRowColumnNum(sheet);
        if (mxrcn.getMaxColumnNum() < ActionDataExcelKeysEnum.MAX_COLUMN_NUM) {
            throw new ExcelAnalysisException("最大列数小于需求列数");
        }
        LinkedList<ActionData> examineeAchievementsList = new LinkedList<>();
        // 逐行解读
        Row row = null;
        String value = null;
        for (int rowNum = 1; rowNum <= mxrcn.getMaxRowNum(); rowNum++) {
            row = sheet.getRow(rowNum);
            if (row != null) {
                examineeAchievementsList.add(new ActionData());
                for (ActionDataExcelKeysEnum eKey : ActionDataExcelKeysEnum.values()) {
                    Cell cell = row.getCell(eKey.getIndex());

                    if (cell == null) {
                        value = null;
                    } else {
                        value = getValue(eKey, cell);
                    }
                    ActionDataExcelKeysEnum.setField(examineeAchievementsList.getLast(), eKey, value);
                }
            }
        }

        return examineeAchievementsList;

    }

    public static void main(String[] args) throws ExcelAnalysisException, EncryptedDocumentException,
            InvalidFormatException, FileNotFoundException, IOException {
        // File file = new File("D:\\company\\gWXKJ工作\\2016 微校项目\\5. cmgso\\2.
        // 后台管理系统\\测试 - 副本.xls");
        File file = new File(
                "D:\\company\\gWXKJ工作\\2016 微校项目\\5. cmgso\\3. 保障\\6a063eabf2e64dce9c5333241ca318f827c75d9db8.xls");
        List<ActionData> x = ExcelReadUtils.readExcel(new FileInputStream(file));
        for (ActionData actionData : x) {
            log.info(actionData.toString());
        }
    }
}

/**
 * Excel解析异常
 * 
 * @author tHgHt-xueXi
 *
 */
class ExcelAnalysisException extends InvalidActivityException {
    private static final long serialVersionUID = 1L;

    public ExcelAnalysisException(String message) {
        super(message);
    }

    public ExcelAnalysisException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * 最大行列数对象
 * 
 * @author tHgHt-xueXi
 *
 */
class MaxRowColumnNum {
    private int maxRowNum;
    private int maxColumnNum;

    public MaxRowColumnNum(Sheet sheet) {
        init(sheet);
    }

    public int getMaxRowNum() {
        return maxRowNum;
    }

    public int getMaxColumnNum() {
        return maxColumnNum;
    }

    private void init(Sheet sheet) {
        this.maxRowNum = sheet.getLastRowNum();
        this.maxColumnNum = 0;
        for (int rowNum = 0; rowNum <= maxRowNum; rowNum++) {
            if (sheet.getRow(rowNum) == null) {
                continue;
            }
            if (sheet.getRow(rowNum).getLastCellNum() > maxColumnNum) {
                maxColumnNum = sheet.getRow(rowNum).getLastCellNum();
            }
        }
    }

}
