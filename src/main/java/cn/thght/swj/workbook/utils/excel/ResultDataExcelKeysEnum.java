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
    NAME(0, "姓名"),
    /** 邮编 */
    ZIPCODE(1, "邮编"),
    /** 地址 */
    ADDRESS(2, "地址"),
    /** 客户编号 */
    CUSTOMERNUMBER(3, "客户编号"),
    /** 账户级别 */
    LEVEL(4, "账户级别"),
    /** 报告日 */
    REPORTDAY(5, "报告日"),
    /** 报告周期 */
    REPORTCYCLE(6, "报告周期"),
    /** 账单接收方式 */
    BILLACCEPTANCE(7, "账单接收方式"),
    /** 邮箱 */
    EMAIL(8, "邮箱"),
    /** 合计初始出借金额 */
    INITIALLOANAMOUNTSUM(9, "合计初始出借金额"),

    /** 合计报告日回款总额 */
    TOTALREPORTDAYRETURNSSUM(10, "合计报告日回款总额"),
    /** 合计报告日资金总额 */
    TOTALREPORTDAYASSETSSUM(11, "合计报告日资金总额"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING(12, "资金出借及回收方式"),
    /** 初始出借日期 */
    INITIALLOANDATE(13, "初始出借日期"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT(14, "初始出借金额"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS(15, "报告日回款总额"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS(16, "报告日资产总额"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING1(17, "资金出借及回收方式1"),
    /** 初始出借日期 */
    INITIALLOANDATE1(18, "初始出借日期1"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT1(19, "初始出借金额1"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS1(20, "报告日回款总额1"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS1(21, "报告日资产总额1"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING2(22, "资金出借及回收方式2"),
    /** 初始出借日期 */
    INITIALLOANDATE2(23, "初始出借日期2"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT2(24, "初始出借金额2"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS2(25, "报告日回款总额2"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS2(26, "报告日资产总额2"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING3(27, "资金出借及回收方式3"),
    /** 初始出借日期 */
    INITIALLOANDATE3(28, "初始出借日期3"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT3(29, "初始出借金额3"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS3(30, "报告日回款总额3"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS3(31, "报告日资产总额3"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING4(32, "资金出借及回收方式4"),
    /** 初始出借日期 */
    INITIALLOANDATE4(33, "初始出借日期4"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT4(34, "初始出借金额4"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS4(35, "报告日回款总额4"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS4(36, "报告日资产总额4"),

    /** 资金出借及回收方式 */
    FUNDLENDINGANDRECYCLING5(37, "资金出借及回收方式5"),
    /** 初始出借日期 */
    INITIALLOANDATE5(38, "初始出借日期5"),
    /** 初始出借金额 */
    INITIALLOANAMOUNT5(39, "初始出借金额5"),
    /** 报告日回款总额 */
    TOTALREPORTDAYRETURNS5(40, "报告日回款总额5"),
    /** 报告日资产总额 */
    TOTALREPORTDAYASSETS5(41, "报告日资产总额5"),

    ;
    /** 解析的列数,小于这个数表示信息不完整或不符合成绩导入模板 */
    public static final int MAX_COLUMN_NUM = 42;

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

    public static void setField(ResultData resultData, ResultDataExcelKeysEnum key, HSSFCell cell) {
        switch (key) {
        case NAME:
            cell.setCellValue(resultData.getName());
            break;
        case ZIPCODE:
            cell.setCellValue(resultData.getZipCode());
            break;
        case ADDRESS:
            cell.setCellValue(resultData.getAddress());
            break;
        case CUSTOMERNUMBER:
            cell.setCellValue(resultData.getCustomerNumber());
            break;
        case LEVEL:
            cell.setCellValue(resultData.getLevel());
            break;
        case REPORTDAY:
            cell.setCellValue(resultData.getReportDay());
            break;
        case REPORTCYCLE:
            cell.setCellValue(resultData.getReportCycle());
            break;
        case BILLACCEPTANCE:
            cell.setCellValue(resultData.getBillAcceptance());
            break;
        case EMAIL:
            cell.setCellValue(resultData.getEmail());
            break;
        case INITIALLOANAMOUNTSUM:
            cell.setCellValue(resultData.getInitialLoanAmountSum());
            break;
        case TOTALREPORTDAYRETURNSSUM:
            cell.setCellValue(resultData.getTotalReportDayReturnsSum());
            break;
        case TOTALREPORTDAYASSETSSUM:
            cell.setCellValue(resultData.getTotalReportDayAssetsSum());
            break;
        case FUNDLENDINGANDRECYCLING:
            cell.setCellValue(resultData.getFundLendingAndRecycling());
            break;
        case INITIALLOANDATE:
            cell.setCellValue(resultData.getInitialLoanDate());
            break;
        case INITIALLOANAMOUNT:
            cell.setCellValue(resultData.getInitialLoanAmount());
            break;
        case TOTALREPORTDAYRETURNS:
            cell.setCellValue(resultData.getTotalReportDayReturns());
            break;
        case TOTALREPORTDAYASSETS:
            cell.setCellValue(resultData.getTotalReportDayAssets());
            break;
        case FUNDLENDINGANDRECYCLING1:
            cell.setCellValue(resultData.getFundLendingAndRecycling1());
            break;
        case INITIALLOANDATE1:
            cell.setCellValue(resultData.getInitialLoanDate1());
            break;
        case INITIALLOANAMOUNT1:
            cell.setCellValue(resultData.getInitialLoanAmount1());
            break;
        case TOTALREPORTDAYRETURNS1:
            cell.setCellValue(resultData.getTotalReportDayReturns1());
            break;
        case TOTALREPORTDAYASSETS1:
            cell.setCellValue(resultData.getTotalReportDayAssets1());
            break;
        case FUNDLENDINGANDRECYCLING2:
            cell.setCellValue(resultData.getFundLendingAndRecycling2());
            break;
        case INITIALLOANDATE2:
            cell.setCellValue(resultData.getInitialLoanDate2());
            break;
        case INITIALLOANAMOUNT2:
            cell.setCellValue(resultData.getInitialLoanAmount2());
            break;
        case TOTALREPORTDAYRETURNS2:
            cell.setCellValue(resultData.getTotalReportDayReturns2());
            break;
        case TOTALREPORTDAYASSETS2:
            cell.setCellValue(resultData.getTotalReportDayAssets2());
            break;
        case FUNDLENDINGANDRECYCLING3:
            cell.setCellValue(resultData.getFundLendingAndRecycling3());
            break;
        case INITIALLOANDATE3:
            cell.setCellValue(resultData.getInitialLoanDate3());
            break;
        case INITIALLOANAMOUNT3:
            cell.setCellValue(resultData.getInitialLoanAmount3());
            break;
        case TOTALREPORTDAYRETURNS3:
            cell.setCellValue(resultData.getTotalReportDayReturns3());
            break;
        case TOTALREPORTDAYASSETS3:
            cell.setCellValue(resultData.getTotalReportDayAssets3());
            break;
        case FUNDLENDINGANDRECYCLING4:
            cell.setCellValue(resultData.getFundLendingAndRecycling4());
            break;
        case INITIALLOANDATE4:
            cell.setCellValue(resultData.getInitialLoanDate4());
            break;
        case INITIALLOANAMOUNT4:
            cell.setCellValue(resultData.getInitialLoanAmount4());
            break;
        case TOTALREPORTDAYRETURNS4:
            cell.setCellValue(resultData.getTotalReportDayReturns4());
            break;
        case TOTALREPORTDAYASSETS4:
            cell.setCellValue(resultData.getTotalReportDayAssets4());
            break;
        case FUNDLENDINGANDRECYCLING5:
            cell.setCellValue(resultData.getFundLendingAndRecycling5());
            break;
        case INITIALLOANDATE5:
            cell.setCellValue(resultData.getInitialLoanDate5());
            break;
        case INITIALLOANAMOUNT5:
            cell.setCellValue(resultData.getInitialLoanAmount5());
            break;
        case TOTALREPORTDAYRETURNS5:
            cell.setCellValue(resultData.getTotalReportDayReturns5());
            break;
        case TOTALREPORTDAYASSETS5:
            cell.setCellValue(resultData.getTotalReportDayAssets5());
            break;

        default:
            break;
        }

    }

}
