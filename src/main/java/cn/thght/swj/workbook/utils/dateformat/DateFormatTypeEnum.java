package cn.thght.swj.workbook.utils.dateformat;

/**
 * 时间格式
 * 
 * @author tHgHt-xueXi
 *
 */
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

    DateFormatTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
