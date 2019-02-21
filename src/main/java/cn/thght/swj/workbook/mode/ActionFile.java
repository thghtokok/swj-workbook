package cn.thght.swj.workbook.mode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.thght.swj.workbook.utils.dateformat.DateFormatTypeEnum;
import cn.thght.swj.workbook.utils.dateformat.DateFormatUtils;
import lombok.extern.log4j.Log4j;

/**
 * 对文件进行处理
 * 
 * @author 作者: thght
 * @version 创建时间: 2018年6月30日
 */
@Log4j
public class ActionFile {
    private LinkedHashMap<String, LinkedList<ActionData>> actionFileMap;

    public Map<String, LinkedList<ActionData>> getActionFile() {
        ArrayList<Map.Entry<String, LinkedList<ActionData>>> list = new ArrayList<>(this.actionFileMap.entrySet());
        try {
            Collections.sort(list, new UserSort());
        } catch (Exception e) {
            log.error("context", e);

        }
        LinkedHashMap<String, LinkedList<ActionData>> resultMap = new LinkedHashMap<>();
        for (Entry<String, LinkedList<ActionData>> entry : list) {
            resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }

    public ActionFile(List<ActionData> dataList) {
        super();
        this.actionFileMap = new LinkedHashMap<>();
        init(dataList);
    }

    private void init(List<ActionData> dataList) {
        for (ActionData actionData : dataList) {
            this.setActionData(actionData);
        }
        this.sort();
    }

    private void setActionData(ActionData actionData) {
        if (!actionFileMap.containsKey(actionData.getIdNumber())) {
            actionFileMap.put(actionData.getIdNumber(), new LinkedList<>());
        }
        actionFileMap.get(actionData.getIdNumber()).addLast(actionData);
    }

    private void sort() {
        for (Entry<String, LinkedList<ActionData>> entry : this.actionFileMap.entrySet()) {
            Collections.sort(entry.getValue(), new ActionDataSort());
        }
    }

}

class ActionDataSort implements Comparator<ActionData> {

    @Override
    public int compare(ActionData o1, ActionData o2) {
        try {
            Date o1Date = DateFormatUtils.stringToDate(o1.getInitialLoanDate(), DateFormatTypeEnum.ONE);
            Date o2Date = DateFormatUtils.stringToDate(o2.getInitialLoanDate(), DateFormatTypeEnum.ONE);

            if (o1Date.before(o2Date)) {
                return -1;
            }
            if (o1Date.after(o2Date)) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

}

@Log4j
class UserSort implements Comparator<Map.Entry<String, LinkedList<ActionData>>> {

    @Override
    public int compare(Map.Entry<String, LinkedList<ActionData>> o1, Map.Entry<String, LinkedList<ActionData>> o2) {
        if (o1 == null) {
            log.error("o1 == null");
            return 0;
        }
        if (o2 == null) {
            log.error("o2 == null");
            return 0;
        }
        try {

            int i1 = o1.getValue().size();
            int i2 = o2.getValue().size();

            if (i2 - i1 != 0) {
                return i2 - i1;
            }

            return o2.getKey().hashCode() % 100 - o1.getKey().hashCode() % 100;
        } catch (Exception e) {
            log.error("context", e);
            return 0;
        }
    }

}
