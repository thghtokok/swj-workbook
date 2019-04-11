package cn.thght.swj.workbook.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;

import cn.thght.swj.workbook.mode.ResultData;

/**
 * 赛区成绩导入模板
 * 
 * @author tHgHt-xueXi
 *
 */
public enum ResultDataExcelKeysEnum {
    /** 姓名 */
    NAME(0, "姓名") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getName());
        }
    },
    /** 邮编 */
    ZIPCODE(1, "邮编") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getZipCode());
        }
    },
    /** 地址 */
    ADDRESS(2, "地址") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getAddress());
        }
    },
    /** 客户编号 */
    CUSTOMERNUMBER(3, "客户编号") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getCustomerNumber());
        }
    },
    /** 账户级别 */
    LEVEL(4, "账户级别") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getLevel());
        }
    },
    /** 报告日 */
    REPORTDAY(5, "报告日") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getReportDay());
        }
    },
    /** 报告周期 */
    REPORTCYCLE(6, "报告周期") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getReportCycle());
        }
    },
    /** 账单接收方式 */
    BILLACCEPTANCE(7, "账单接收方式") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getBillAcceptance());
        }
    },
    /** 邮箱 */
    EMAIL(8, "邮箱") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getEmail());
        }
    },
    /** 合计初始出借金额 */
    INITIALLOANAMOUNTSUM(9, "合计初始出借金额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmountSum());
        }
    },

    /** 合计报告日回款总额 */
    TOTALREPORTDAYRETURNSSUM(10, "合计报告日回款总额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturnsSum());
        }
    },
    /** 合计报告日资金总额 */
    TOTALREPORTDAYASSETSSUM(11, "合计报告日资金总额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssetsSum());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING(12, "资金出借及回收方式") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE(13, "初始出借日期") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT(14, "初始出借金额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS(15, "报告日回款总额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS(16, "报告日资产总额") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING1(17, "资金出借及回收方式1") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling1());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE1(18, "初始出借日期1") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate1());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT1(19, "初始出借金额1") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount1());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS1(20, "报告日回款总额1") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns1());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS1(21, "报告日资产总额1") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets1());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING2(22, "资金出借及回收方式2") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling2());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE2(23, "初始出借日期2") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate2());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT2(24, "初始出借金额2") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount2());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS2(25, "报告日回款总额2") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns2());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS2(26, "报告日资产总额2") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets2());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING3(27, "资金出借及回收方式3") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling3());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE3(28, "初始出借日期3") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate3());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT3(29, "初始出借金额3") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount3());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS3(30, "报告日回款总额3") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns3());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS3(31, "报告日资产总额3") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets3());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING4(32, "资金出借及回收方式4") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling4());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE4(33, "初始出借日期4") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate4());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT4(34, "初始出借金额4") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount4());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS4(35, "报告日回款总额4") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns4());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS4(36, "报告日资产总额4") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets4());
        }
    },

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING5(37, "资金出借及回收方式5") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getFundLendingAndRecycling5());
        }
    },
    /** 初始出借日期 */
    INITIALLOANDATE5(38, "初始出借日期5") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanDate5());
        }
    },
    /** 初始出借金额 */
    INITIALLOANAMOUNT5(39, "初始出借金额5") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getInitialLoanAmount5());
        }
    },
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS5(40, "报告日回款总额5") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayReturns5());
        }
    },
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS5(41, "报告日资产总额5") {
        @Override
        public void setField(ResultData resultData, HSSFCell cell) {
            cell.setCellValue(resultData.getTotalReportDayAssets5());
        }
    },

    ;
    /** 解析的列数,小于这个数表示信息不完整或不符合成绩导入模板 */
    public static final int MAX_COLUMN_NUM = 42;

    public abstract void setField(ResultData resultData, HSSFCell cell);

    private int index;
    private String columnname;

    private ResultDataExcelKeysEnum(int index, String columnname) {
        this.index = index;
        this.columnname = columnname;
    }

    public int getIndex() {
        return index;
    }

    public String getColumnname() {
        return columnname;
    }

}
