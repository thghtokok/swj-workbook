package cn.thght.swj.workbook.utils;

/**
 * @author thght
 * @Date 创建日期:2019年9月3日
 */

public class FileNameUtils {

    private FileNameUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 不带文件后缀的文件名
     * 
     * @param filename
     * @return
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     * 得到文件的后缀
     * 
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }
}
