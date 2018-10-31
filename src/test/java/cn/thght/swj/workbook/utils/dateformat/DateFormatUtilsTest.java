package cn.thght.swj.workbook.utils.dateformat;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年8月31日
 */
public class DateFormatUtilsTest {

    @Test
    public void testStringToDateStringDateFormatTypeEnum() {
        String string = "2018/8/31";
        Date date = DateFormatUtils.stringToDate(string,DateFormatTypeEnum.ONE);
        System.out.println(date);
    }

}
