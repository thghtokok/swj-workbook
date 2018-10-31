package cn.thght.swj.workbook.mode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
public class ActionDataTest {

    /**
     * 测试字符串的转换
     */
    @Test
    public void test() {
        String str = "王培,110102196110243048,100011,北京市东城区安德路47号院3号楼2门231室,cic-00495,,2017/11/30,十一月,邮寄,,中投富民,2014/3/3,\"100,000.00 \",0.00,\"162,723.08 \",13.0%,3.0";
        String regStr = "^(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*),(\".*\"),(.*),(\".*\"),(.*),(.*)$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            for(int i = 0 ; i <= matcher.groupCount() ; i ++) {
                System.out.println(matcher.group(i));
            }
        }
        // fail("Not yet implemented");
    }

}
