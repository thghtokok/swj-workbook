package cn.thght.swj.workbook.mode;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;
import cn.thght.swj.workbook.utils.dateformat.DateFormatUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
public class ResultFile {

    private LinkedList<ResultData> resultDataList;

    public LinkedList<ResultData> getResultDataList() {
        return resultDataList;
    }

    // 一行最多6个数据
    private static final int ROW_DATA_MAX = 6;

    public ResultFile(ActionFile actionFile) {
        super();
        resultDataList = new LinkedList<>();
        init(actionFile);
    }

    /**
     * 将actionFile 转变为 resultFile
     * 
     * @param actionFile
     */
    private void init(ActionFile actionFile) {
        Collection<LinkedList<ActionData>> userList = actionFile.getActionFile().values();

        for (LinkedList<ActionData> userData : userList) {
            this.userDataToResultData(userData);
        }

    }

    /**
     * 将userData转为ResultData
     * 
     * @param userData
     */
    private void userDataToResultData(LinkedList<ActionData> userData) {
        // 行数据计数
        int rowDataCount = 0;

        // 行号
        int rownum = 0;

        ActionData commonData = userData.getLast();

        Collections.sort(userData, new ResultDataSort());

        if (userData.size() % ROW_DATA_MAX == 0) {
            rowDataCount = userData.size() / ROW_DATA_MAX;
        } else {
            rowDataCount = userData.size() / ROW_DATA_MAX + 1;
        }

        for (int i = 0; i < rowDataCount; i++) {
            this.resultDataList.addLast(new ResultData(commonData));
            rownum = setData(userData, rownum);
            if (rownum == -1) {
                break;
            }
        }

    }

    private int setData(LinkedList<ActionData> userData, int rownum) {

        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData1(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData2(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData3(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData4(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        if (rownum < userData.size() && userData.get(rownum) != null) {
            this.resultDataList.getLast().setData5(userData.get(rownum));
        } else {
            return -1;
        }
        rownum++;
        return rownum;
    }

}

@Setter
@Getter
class ResultDataSort implements Comparator<ActionData> {

    private boolean modeSort = false;

    public ResultDataSort() {
        super();
    }

    public ResultDataSort(boolean modeSort) {
        super();
        this.modeSort = modeSort;
    }

    private int getSort(String str) {
        switch (str) {
        case "中投富民":
            return 1;
        case "中投富民A":
            return 2;
        case "中投富民B":
            return 3;
        case "中投利民":
            return 4;
        case "中投利民A":
            return 5;
        case "中投利民B":
            return 6;

        default:
            return 7;
        }
    }

    @Override
    public int compare(ActionData o1, ActionData o2) {
        if (modeSort && this.getSort(o1.getInitialLoanAmount()) != this.getSort(o2.getInitialLoanAmount())) {
            return this.getSort(o1.getInitialLoanAmount()) - this.getSort(o2.getInitialLoanAmount());
        }

        Date o1Date = DateFormatUtils.stringToDate(o1.getInitialLoanDate(), DateFormatTypeEnum.ONE);
        Date o2Date = DateFormatUtils.stringToDate(o2.getInitialLoanDate(), DateFormatTypeEnum.ONE);

        if (o1Date.before(o2Date)) {
            return 1;
        }
        if (o1Date.after(o2Date)) {
            return -1;
        }
        return 0;
    }

}
