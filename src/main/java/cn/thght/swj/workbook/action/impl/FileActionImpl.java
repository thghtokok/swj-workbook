package cn.thght.swj.workbook.action.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.thght.swj.workbook.action.FileAction;
import cn.thght.swj.workbook.mode.ActionData;
import cn.thght.swj.workbook.mode.ActionFile;
import cn.thght.swj.workbook.mode.ResultFile;
import cn.thght.swj.workbook.utils.excel.ExcelReadUtils;
import cn.thght.swj.workbook.utils.excel.ExcelWriteUtils;
import lombok.extern.log4j.Log4j;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@Service
@Log4j
public class FileActionImpl implements FileAction {

    private static final String SHEET_NAME = "整理后";

    @Override
    public ActionFile read(File file) {
        List<ActionData> actionDataList;
        try (FileInputStream fis = new FileInputStream(file)) {
            actionDataList = ExcelReadUtils.readExcel(fis);
            if (actionDataList != null && !actionDataList.isEmpty()) {
                return new ActionFile(actionDataList);
            }
        } catch (Exception e) {
            log.error("context", e);
        }
        return null;
    }

    @Override
    public boolean wirte(ResultFile resultFile, File file) {
        log.info(file.getName() + " 存在: " + file.exists());
        try {
            ExcelWriteUtils.createExcel(file, SHEET_NAME);
            ExcelWriteUtils.writeToExcel(SHEET_NAME, resultFile.getResultDataList(), file);

        } catch (Exception e) {
            log.error("context", e);
            return false;
        }

        return true;
    }

}
