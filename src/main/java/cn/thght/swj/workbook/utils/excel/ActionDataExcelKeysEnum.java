package cn.thght.swj.workbook.utils.excel;

import cn.thght.swj.workbook.mode.ActionData;
import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;
import cn.thght.swj.workbook.utils.dateformat.DateFormatUtils;

/**
 * 赛区成绩导入模板
 * 
 * @author tHgHt-xueXi
 *
 */
public enum ActionDataExcelKeysEnum {
    /** 姓名 */
    NAME(0, "姓名"),
    /** 证件号 */
    IDNUMBER(1, "证件号"),
    /** 邮编 */
    ZIPCODE(2, "邮编"),
    /** 地址 */
    ADDRESS(3, "地址"),
    /** 客户编号 */
    CUSTOMERNUMBER(4, "客户编号"),
    /** 账户级别 */
    LEVEL(5, "账户级别"),
    /** 报告日 */
    REPORTDAY(6, "报告日"),
    /** 报告周期 */
    REPORTCYCLE(7, "报告周期"),
    /** 账单接收方式 */
    BILLACCEPTANCE(8, "账单接收方式"),
    /** 邮箱 */
    EMAIL(9, "邮箱"),
    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING(10, "资金出借及回收方式"),
    /** 初始出借日期 */
    INITIALLOANDATE(11, "初始出借日期"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT(12, "初始出借金额"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS(13, "报告日回款总额"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS(14, "报告日资产总额"),
    /** 理财年收益 */
    INCOMEOFFINANCIALYEAR(15, "理财年收益"),
    /** 版本 */
    VERSION(16, "版本"),;

    /** 解析的列数,小于这个数表示信息不完整或不符合成绩导入模板 */
    public static final int MAX_COLUMN_NUM = 17;

    private int index;
    private String columnname;

    private ActionDataExcelKeysEnum(int index, String columnname) {
        this.index = index;
        this.columnname = columnname;
    }

    public int getIndex() {
        return index;
    }

    public String getColumnname() {
        return columnname;
    }

    public static void setField(ActionData actionData, ActionDataExcelKeysEnum key, String value) {
        String temp = null;
        switch (key) {
        case NAME:
            actionData.setName(value);
            break;
        case IDNUMBER:
            actionData.setIdNumber(value.toUpperCase());
            break;
        case ZIPCODE:
            actionData.setZipCode(value);
            break;
        case ADDRESS:
            actionData.setAddress(value);
            break;
        case CUSTOMERNUMBER:
            actionData.setCustomerNumber(value);
            break;
        case LEVEL:
            actionData.setLevel(value);
            break;
        case REPORTDAY:

            if (value != null) {
                try {
                    temp = DateFormatUtils.format(DateFormatUtils.stringToDate(value, DateFormatTypeEnum.FIVE),
                            DateFormatTypeEnum.ONE_SHORT);
                } catch (Exception e) {
                }
                if (temp == null) {
                    try {
                        temp = DateFormatUtils.format(DateFormatUtils.stringToDate(value, DateFormatTypeEnum.ONE),
                                DateFormatTypeEnum.ONE_SHORT);
                    } catch (Exception e) {
                    }
                }
            }

            actionData.setReportDay(temp);
            break;
        case REPORTCYCLE:
            actionData.setReportCycle(value);
            break;
        case BILLACCEPTANCE:
            actionData.setBillAcceptance(value);
            break;
        case EMAIL:
            actionData.setEmail(value);
            break;
        case FUNDLENDINGANDRECYCLING:
            actionData.setFundLendingAndRecycling(value);
            break;
        case INITIALLOANDATE:
            if (value != null) {
                try {
                    temp = DateFormatUtils.format(DateFormatUtils.stringToDate(value, DateFormatTypeEnum.FIVE),
                            DateFormatTypeEnum.ONE_SHORT);
                } catch (Exception e) {
                }
                if (temp == null) {
                    try {
                        temp = DateFormatUtils.format(DateFormatUtils.stringToDate(value, DateFormatTypeEnum.ONE),
                                DateFormatTypeEnum.ONE_SHORT);
                    } catch (Exception e) {
                    }
                }
            }
            actionData.setInitialLoanDate(temp);
            break;
        case INITIALLOANAMOUNT:
            actionData.setInitialLoanAmount(value);
            break;
        case TOTALREPORTDAYRETURNS:
            actionData.setTotalReportDayReturns(value);
            break;
        case TOTALREPORTDAYASSETS:
            actionData.setTotalReportDayAssets(value);
            break;
        case INCOMEOFFINANCIALYEAR:
            actionData.setIncomeOfFinancialYear(value);
            break;
        case VERSION:
            actionData.setVersion(value);
            break;

        default:
            break;
        }

    }

}
