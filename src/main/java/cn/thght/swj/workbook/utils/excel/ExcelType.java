package cn.thght.swj.workbook.utils.excel;

/**
 * 用于对上传图片类型的检查
 * 
 * @author tHgHt-xueXi
 *
 */
public enum ExcelType {
    /** EXCEL 2003 .xls*/
    EXCEL_2003(".xls"), 
    /** EXCEL 2010 .xlsx */
    EXCEL_2010(".xlsx");
    String value;

    ExcelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 返回文件类型,如果是允许的类型就返回类型,否则返回空
     * 
     * @param fileName
     * @return
     */
    public static ExcelType allowType(String fileName) {
        for (ExcelType type : ExcelType.values()) {
            if (fileName.toLowerCase().endsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
}
