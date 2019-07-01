package cn.thght.swj.workbook.mode;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import lombok.Data;
import lombok.extern.log4j.Log4j;

/**
 * 结果表的单行记录
 * 
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@Data
@Log4j
public class ResultData {

    public static final DecimalFormat FORMAT = new DecimalFormat("#,##0.00");

    /** 姓名 */
    private String name;
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
    /** Email */
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
    /** 资金出借及回收方式1 */
    private String fundLendingAndRecycling1;
    /** 初始出借日期1 */
    private String initialLoanDate1;
    /** 初始出借金额1 */
    private String initialLoanAmount1;
    /** 报告日回款总额1 */
    private String totalReportDayReturns1;
    /** 报告日资产总额1 */
    private String totalReportDayAssets1;
    /** 资金出借及回收方式2 */
    private String fundLendingAndRecycling2;
    /** 初始出借日期2 */
    private String initialLoanDate2;
    /** 初始出借金额2 */
    private String initialLoanAmount2;
    /** 报告日回款总额2 */
    private String totalReportDayReturns2;
    /** 报告日资产总额2 */
    private String totalReportDayAssets2;
    /** 资金出借及回收方式3 */
    private String fundLendingAndRecycling3;
    /** 初始出借日期3 */
    private String initialLoanDate3;
    /** 初始出借金额3 */
    private String initialLoanAmount3;
    /** 报告日回款总额3 */
    private String totalReportDayReturns3;
    /** 报告日资产总额3 */
    private String totalReportDayAssets3;
    /** 资金出借及回收方式4 */
    private String fundLendingAndRecycling4;
    /** 初始出借日期4 */
    private String initialLoanDate4;
    /** 初始出借金额4 */
    private String initialLoanAmount4;
    /** 报告日回款总额4 */
    private String totalReportDayReturns4;
    /** 报告日资产总额4 */
    private String totalReportDayAssets4;
    /** 资金出借及回收方式5 */
    private String fundLendingAndRecycling5;
    /** 初始出借日期5 */
    private String initialLoanDate5;
    /** 初始出借金额5 */
    private String initialLoanAmount5;
    /** 报告日回款总额5 */
    private String totalReportDayReturns5;
    /** 报告日资产总额5 */
    private String totalReportDayAssets5;

    private BigDecimal resultAdd(BigDecimal result, String num) {
        if (num != null) {
            try {
                result = result.add(new BigDecimal(num.replace(",", "")));
            } catch (NumberFormatException e) {
                log.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /** 合计初始出借金额 */
    public String getInitialLoanAmountSum() {
        BigDecimal result = BigDecimal.ZERO;
        result = resultAdd(result, this.initialLoanAmount);
        result = resultAdd(result, this.initialLoanAmount1);
        result = resultAdd(result, this.initialLoanAmount2);
        result = resultAdd(result, this.initialLoanAmount3);
        result = resultAdd(result, this.initialLoanAmount4);
        result = resultAdd(result, this.initialLoanAmount5);
        return FORMAT.format(result);
    }

    /** 合计报告日回款总额 */
    public String getTotalReportDayReturnsSum() {
        BigDecimal result = BigDecimal.ZERO;
        result = resultAdd(result, this.totalReportDayReturns);
        result = resultAdd(result, this.totalReportDayReturns1);
        result = resultAdd(result, this.totalReportDayReturns2);
        result = resultAdd(result, this.totalReportDayReturns3);
        result = resultAdd(result, this.totalReportDayReturns4);
        result = resultAdd(result, this.totalReportDayReturns5);
        return FORMAT.format(result);
    }

    /** 合计报告日资金总额 */
    public String getTotalReportDayAssetsSum() {
        BigDecimal result = BigDecimal.ZERO;
        result = resultAdd(result, this.totalReportDayAssets);
        result = resultAdd(result, this.totalReportDayAssets1);
        result = resultAdd(result, this.totalReportDayAssets2);
        result = resultAdd(result, this.totalReportDayAssets3);
        result = resultAdd(result, this.totalReportDayAssets4);
        result = resultAdd(result, this.totalReportDayAssets5);
        return FORMAT.format(result);
    }

    public void setData(ActionData actionData) {
        this.setFundLendingAndRecycling(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate(actionData.getInitialLoanDate());
        this.setInitialLoanAmount(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets(actionData.getTotalReportDayAssets());
    }

    public void setData1(ActionData actionData) {
        this.setFundLendingAndRecycling1(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate1(actionData.getInitialLoanDate());
        this.setInitialLoanAmount1(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns1(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets1(actionData.getTotalReportDayAssets());
    }

    public void setData2(ActionData actionData) {
        this.setFundLendingAndRecycling2(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate2(actionData.getInitialLoanDate());
        this.setInitialLoanAmount2(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns2(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets2(actionData.getTotalReportDayAssets());
    }

    public void setData3(ActionData actionData) {
        this.setFundLendingAndRecycling3(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate3(actionData.getInitialLoanDate());
        this.setInitialLoanAmount3(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns3(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets3(actionData.getTotalReportDayAssets());
    }

    public void setData4(ActionData actionData) {
        this.setFundLendingAndRecycling4(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate4(actionData.getInitialLoanDate());
        this.setInitialLoanAmount4(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns4(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets4(actionData.getTotalReportDayAssets());
    }

    public void setData5(ActionData actionData) {
        this.setFundLendingAndRecycling5(actionData.getFundLendingAndRecycling());
        this.setInitialLoanDate5(actionData.getInitialLoanDate());
        this.setInitialLoanAmount5(actionData.getInitialLoanAmount());
        this.setTotalReportDayReturns5(actionData.getTotalReportDayReturns());
        this.setTotalReportDayAssets5(actionData.getTotalReportDayAssets());
    }

    public ResultData(ActionData actionData) {
        super();
        this.name = actionData.getName();
        this.zipCode = actionData.getZipCode();
        this.address = actionData.getAddress();
        this.customerNumber = actionData.getCustomerNumber();
        this.level = actionData.getLevel();
        this.reportDay = actionData.getReportDay();
        this.reportCycle = actionData.getReportCycle();
        this.billAcceptance = actionData.getBillAcceptance();
        this.email = actionData.getEmail();
    }

    public ResultData() {
        super();
    }

}
