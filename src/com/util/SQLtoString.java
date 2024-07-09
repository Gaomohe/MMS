package com.util;

public class SQLtoString {
    public static String getSQL(String[] key, Object[] valueList, String table) {
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
                    // 对于字符串类型，使用LIKE，并自动添加%通配符
                    String likeValue = "%" + value.toString() + "%"; // 注意：这里总是添加%
                    whereClause.append(columnName).append(" LIKE '").append(likeValue.replace("'", "''")).append("'");
                    // 注意：这里还处理了字符串中的单引号，以避免SQL注入（尽管更好的做法是使用预处理语句）
                } else if (value instanceof Integer || value instanceof Long) {
                    // 对于整数类型，使用=
                    whereClause.append(columnName).append(" = ").append(value);
                }
                // 可以根据需要添加对其他数据类型的支持

                isFirstCondition = false;
            }
            // 如果value为null，则忽略该条件
        }

        // 如果至少添加了一个条件，则在查询中添加WHERE子句
        if (!isFirstCondition) {
            whereClause.insert(0, " WHERE ");
        }

        // 构建完整的查询语句
        String sql = "SELECT * FROM " + table + whereClause.toString();
        System.out.println(sql);
        return sql;
    }

    public static void main(String[] args) {
        String[] keys = {"applyId","applyUser","mName"};
        Object[] values = {"","张三",""};
        getSQL(keys,values,"apply");
    }
}
