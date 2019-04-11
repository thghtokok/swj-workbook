package cn.thght.swj.workbook.utils.dateformat;

import java.text.ParseException;
import java.util.Date;

import lombok.extern.log4j.Log4j2;

/**
 * 时间格式
 * 
 * @author tHgHt-xueXi
 *
 */
@Log4j2
public enum DateFormatTypeEnum {
    /** yyyy/MM/dd */
    ONE("yyyy/MM/dd"),
    /** yyyy/M/d */
    ONE_SHORT("yyyy/M/d"),
    /** yyyy-MM-dd */
    TWO("yyyy-MM-dd"),
    /** yyyy-MM-dd HH:mm:ss */
    THREE("yyyy-MM-dd HH:mm:ss"),
    /** yy-MM-dd */
    FOUR("yy-MM-dd"),
    /** yyyy/MM/dd HH:mm:ss */
    FIVE("yyyy/MM/dd HH:mm:ss"),
    /** yyyyMMdd */
    SIX("yyyyMMdd"),
    /** yyyyMMddHHmm */
    SEVEN("yyyyMMddHHmm"),

    ;
    private String value;

    public String format(Date date) {
        return DateFormatUtils.format(date, this);
    }

    public Date parse(String str) {
        try {
            return DateFormatUtils.stringToDate(str, this);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    DateFormatTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
