package cn.thght.swj.workbook.utils.excel;

import cn.thght.swj.workbook.mode.ActionData;
import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;

/**
 * 赛区成绩导入模板
 * 
 * @author tHgHt-xueXi
 *
 */
public enum ActionDataExcelKeysEnum {
    /** 姓名 */
    NAME(0, "姓名") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setName(value);
        }
    },
    /** 证件号 */
    IDNUMBER(1, "证件号") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setIdNumber(value.toUpperCase());
        }
    },
    /** 邮编 */
    ZIPCODE(2, "邮编") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setZipCode(value);
        }
    },
    /** 地址 */
    ADDRESS(3, "地址") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setAddress(value);
        }
    },
    /** 客户编号 */
    CUSTOMERNUMBER(4, "客户编号") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setCustomerNumber(value);
        }
    },
    /** 账户级别 */
    LEVEL(5, "账户级别") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setLevel(value);
        }
    },
    /** 报告日 */
    REPORTDAY(6, "报告日") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setReportDay(ActionDataExcelKeysEnum.getDate(value));
        }
    },
    /** 报告周期 */
    REPORTCYCLE(7, "报告周期") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setReportCycle(value);
        }
    },
    /** 账单接收方式 */
    BILLACCEPTANCE(8, "账单接收方式") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setBillAcceptance(value);
        }
    },
    /** 邮箱 */
    EMAIL(9, "邮箱") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setEmail(value);
        }
    },
    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING(10, "资金出借及回收方式") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setFundLendingAndRecycling(value);
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE(11, "初始出借日期") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setInitialLoanDate(ActionDataExcelKeysEnum.getDate(value));
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT(12, "初始出借金额") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setInitialLoanAmount(value);
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS(13, "报告日回款总额") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setTotalReportDayReturns(value);
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS(14, "报告日资产总额") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setTotalReportDayAssets(value);
        }
    },
    /** 理财年收益 */
    INCOMEOFFINANCIALYEAR(15, "理财年收益") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setIncomeOfFinancialYear(value);
        }
    },
    /** 版本 */
    VERSION(16, "版本") {
        @Override
        public void setField(ActionData actionData, String value) {
            actionData.setVersion(value);
        }
    },

    ;

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

    public abstract void setField(ActionData actionData, String value);

    private static String getDate(String value) {
        String temp = null;
        if (value != null) {
            temp = DateFormatTypeEnum.ONE_SHORT.format(DateFormatTypeEnum.FIVE.parse(value));
            if (temp == null) {
                temp = DateFormatTypeEnum.ONE_SHORT.format(DateFormatTypeEnum.ONE.parse(value));
            }
        }
        return temp;
    }
}
