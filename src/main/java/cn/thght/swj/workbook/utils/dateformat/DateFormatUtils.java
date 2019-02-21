package cn.thght.swj.workbook.utils.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.util.StringUtils;

import lombok.extern.log4j.Log4j;

/**
 * Date 与 String 转换工具类
 * 
 * @author tHgHt-xueXi
 *
 */
@Log4j
public final class DateFormatUtils {
    /**
     * 将字符串转为 long类型的时间戳 秒级别的<br>
     * 字符串的时间格式为 : yyyy-MM-dd
     * 
     * @param dateStr
     * @return
     */
    public static long dateToStempAsLong(String dateStr) {
        long timeStemp = 0L;
        if (StringUtils.isEmpty(dateStr)) {
            return timeStemp;
        }
        /** 1000毫秒等于1秒 */
        final short msToS = 1000;
        try {
            Date date = getSimpleDateFormat(DateFormatTypeEnum.TWO).parse(dateStr);
            // mysql比java的时间戳少三位
            timeStemp = date.getTime() / msToS;
        } catch (ParseException e) {
            log.error(e.getMessage());
        }

        return timeStemp;
    }

    /**
     * 将字符串转为 double类型的时间戳 秒级别的<br>
     * 字符串的时间格式为 : yyyy-MM-dd
     * 
     * @param dateStr
     * @return
     */
    public static double dateToStempAsDouble(String dateStr) {
        return dateToStempAsLong(dateStr);
    }

    /**
     * 返回GMT+8的时间 例子: 470880000000L to 470851200000L
     * 
     * @param sourceTimeStamp GMT
     * @return 北京时间
     */
    public static Date dateTimeZoneGMT8(Long sourceTimeStamp) {
        if (sourceTimeStamp == null) {
            return null;
        }
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        Long targetTime = sourceTimeStamp - timeZone.getRawOffset();
        return new Date(targetTime);
    }

    /**
     * 返回GMT+8的时间
     * 
     * @param sourceTime GMT
     * @return 北京时间
     */
    public static Date dateTimeZoneGMT8(Date sourceTime) {
        if (sourceTime == null) {
            return null;
        }
        return dateTimeZoneGMT8(sourceTime.getTime());
    }

    /**
     * Date String Format yyyy/M/d
     * 
     * @param d 被转换的Date类型数据
     * @return 格式化后的字符串
     */
    public static String format(Date d) {
        return format(d, DateFormatTypeEnum.ONE);
    }

    /**
     * 
     * @param d      被转换的Date类型数据
     * @param format 转换模板
     * @return 格式化后的字符串
     */
    public static String format(Date d, DateFormatTypeEnum format) {
        if (d == null) {
            return null;
        }
        return getSimpleDateFormat(format).format(d);
    }

    /**
     * 将字符串转为Date
     * 
     * @param str
     * @param dateFormatType
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str, DateFormatTypeEnum dateFormatType) throws ParseException {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return getSimpleDateFormat(dateFormatType).parse(str);
    }

    /**
     * 将字符串转为Date
     * 
     * @param str 格式:"yyyy-MM-dd HH:mm:ss"
     * @return
     * @throws ParseException 
     */
    public static Date stringToDate(String str) throws ParseException {
        return stringToDate(str, DateFormatTypeEnum.THREE);
    }

    private static SimpleDateFormat getSimpleDateFormat(DateFormatTypeEnum format) {
        return new SimpleDateFormat(format.getValue());
    }

    private DateFormatUtils() {
        throw new IllegalStateException("Utility class");
    }

}
