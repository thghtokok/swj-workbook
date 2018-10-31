package cn.thght.swj.workbook.mode;

import lombok.Data;

/**
 * 读取文件的记录
 * 
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@Data
public class ActionData {
    /** 姓名 */
    private String name;
    /** 证件号 */
    private String idNumber;
    /** 邮编 */
    private String zipCode;
    /** 地址 */
    private String address;
    /** 客户编号 */
    private String customerNumber;
    /** 账户级别 */
    private String level;
    /** 报告日 */
    private String reportDay;
    /** 报告周期 */
    private String reportCycle;
    /** 账单接收方式 */
    private String billAcceptance;
    /** 邮箱 */
    private String email;
    /** 资金出借及回收方式 */
    private String fundLendingAndRecycling;
    /** 初始出借日期 */
    private String initialLoanDate;
    /** 初始出借金额 */
    private String initialLoanAmount;
    /** 报告日回款总额 */
    private String totalReportDayReturns;
    /** 报告日资产总额 */
    private String totalReportDayAssets;
    /** 理财年收益 */
    private String incomeOfFinancialYear;
    /** 版本 */
    private String version;

    public ActionData() {
        super();
    }

}
