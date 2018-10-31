package cn.thght.swj.workbook.action;

import java.io.File;

import cn.thght.swj.workbook.mode.ActionFile;
import cn.thght.swj.workbook.mode.ResultFile;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
public interface FileAction {

    /**
     * 读文件, 读取文件, 并把它保存为 ActionFile
     * 
     * @param file
     * @return
     */
    ActionFile read(File file);

    /**
     * 写文件
     * 
     * @param resultFile
     * @param file
     * @return
     */
    boolean wirte(ResultFile resultFile, File file);
}
