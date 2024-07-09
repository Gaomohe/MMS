package com.util;

import java.util.HashMap;
import java.util.Map;

public class SQLtoString {
    public static String getSQL(String[] key, Object[] valueList, String table) {
        if (key == null || valueList == null || key.length != valueList.length) {
            throw new IllegalArgumentException("key and valueList must be non-null and of the same length");
        }

        StringBuilder whereClause = new StringBuilder();
        boolean isFirstCondition = true;

        for (int i = 0; i < key.length; i++) {
            Object value = valueList[i];

            if (value != null) {
                if (!isFirstCondition) {
                    whereClause.append(" AND ");
                }

                String columnName = key[i];
                if (value instanceof String) {

                    whereClause.append(columnName).append(" LIKE '").append(value).append("'");
                } else if (value instanceof Integer || value instanceof Long) {
                    whereClause.append(columnName).append(" = ").append(value);
                }
                isFirstCondition = false;
            }
        }

        if (!isFirstCondition) {
            whereClause.insert(0, " WHERE ");
        }

        String sql = "SELECT * FROM " + table + whereClause.toString();
        System.out.println(sql);
        return sql;
    }

    public static void main(String[] args) {
        String[] keys = {"applyId","applyUser"};
        Object[] values = {1,"%张三%"};
        getSQL(keys,values,"apply");
    }
}
