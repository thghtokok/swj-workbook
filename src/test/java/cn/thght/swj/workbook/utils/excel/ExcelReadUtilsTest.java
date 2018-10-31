package cn.thght.swj.workbook.utils.excel;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.thght.swj.workbook.mode.ActionData;
import lombok.extern.log4j.Log4j;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class ExcelReadUtilsTest {

    @Test
    public void testReadExcelInputStream() {

        // File file = new File("action.xlsx");
        // try (FileInputStream fis = new FileInputStream(file);) {
        // List<ActionData> readExcel = ExcelUtils.readExcel(fis);
        // for (ActionData actionData : readExcel) {
        // System.out.println(actionData.toString());
        // }
        //
        // } catch (Exception e) {
        // log.error("context", e);
        // fail("Not yet implemented");
        // }

    }

}
