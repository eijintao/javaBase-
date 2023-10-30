package com.java.base.string;

/**
 * mjt 梅锦涛
 * 2023/10/23
 *
 * @author mjt
 */
public class SqlColumnReorder {

    public static void main(String[] args) {
        String inputSql = "SELECT DATE, DOLLAR_APP_ID, ... , QUESTION_NAME FROM sensors.EVENTS"; // 用你的查询替换
        String reorderedSql = reorderDateColumn(inputSql);
        System.out.println(reorderedSql);
    }

    private static String reorderDateColumn(String sql) {
        // 找到 SELECT 和 FROM 的位置，用于分隔字段
        int selectIndex = sql.toUpperCase().indexOf("SELECT");
        int fromIndex = sql.toUpperCase().indexOf(" FROM ");

        if (selectIndex == -1 || fromIndex == -1) {
            throw new IllegalArgumentException("Invalid SQL format");
        }

        // 提取字段部分并分割
        String columns = sql.substring(selectIndex + 7, fromIndex);
        String[] columnArr = columns.split(",\\s*");

        // 构建新的查询，将DATE字段移到最后
        StringBuilder reorderedColumns = new StringBuilder();
        for (String col : columnArr) {
            if (!"DATE".equalsIgnoreCase(col.trim())) {
                reorderedColumns.append(col).append(", ");
            }
        }
        reorderedColumns.append("DATE");  // 添加DATE字段到最后

        return "SELECT " + reorderedColumns.toString() + sql.substring(fromIndex);
    }
}

