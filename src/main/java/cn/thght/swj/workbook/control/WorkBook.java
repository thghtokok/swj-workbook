package cn.thght.swj.workbook.control;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import cn.thght.swj.workbook.action.FileAction;
import cn.thght.swj.workbook.mode.ActionFile;
import cn.thght.swj.workbook.mode.ResultFile;
import cn.thght.swj.workbook.utils.CommonConst;
import cn.thght.swj.workbook.utils.FileNameUtils;
import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;
import lombok.extern.log4j.Log4j;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@Controller
@Log4j
public class WorkBook implements InitializingBean {

    @Value("${source.file.name:action.xlsx}")
    private String sourceFilename;

    @Value("${result.file.name:result.xlsx}")
    private String resultFilename;

    @Autowired
    private FileAction fileAction;

    /**
     * 读取文件, 整理文件, 输出到文件
     */

    private void action() {
        String thisSourceFilename = CommonConst.designationFileName;
        if (thisSourceFilename == null) {
            thisSourceFilename = sourceFilename;
        }

        File sourceFile = new File(thisSourceFilename);
        if (!sourceFile.exists()) {
            log.error(thisSourceFilename + " 没有找到, 请将文件放到本目录下");
            return;
        }
        log.info("开始读取源文件: " + sourceFilename + " 请稍等...");
        ActionFile actionFile = fileAction.read(sourceFile);
        if (actionFile == null) {
            log.error("读取源文件失败, 处理结束!");
            return;
        }
        log.info("读取源文件完毕, 正在处理中...");
        ResultFile resultFile = ResultFile.create(actionFile);

        if (resultFile == null) {
            log.error("处理失败, 结束!");
            return;
        }

        if (CommonConst.designationFileName != null) {
            resultFilename = FileNameUtils.getFileNameNoEx(sourceFile.getName()) + resultFilename;
        }
        resultFilename = DateFormatTypeEnum.SIX.formatNow() + "_" + resultFilename;

        log.info("处理完毕, 开始写入结果文件: " + resultFilename + " ...");
        fileAction.wirte(resultFile, new File(resultFilename));
        log.info("全部完成!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        action();
    }

}
