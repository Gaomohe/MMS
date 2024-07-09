package com.util;

public class SQLtoString {
    public static String getSQL(String[] key, Object[] valueList, String table) {
        //键——值要一一对应，调用此方法要保证键值数组长度一致
        if (key == null || valueList == null || key.length != valueList.length) {
            throw new IllegalArgumentException("键值长度不一致");
        }
        StringBuilder whereClause = new StringBuilder();
        boolean isFirstCondition = true;

        for (int i = 0; i < key.length; i++) {
            Object value = valueList[i];

            // 检查值是否为null或空字符串，并忽略这些条件
            if (value != null && !(value instanceof String && ((String) value).isEmpty())) {
                if (!isFirstCondition) {
                    whereClause.append(" AND ");
                }

                String columnName = key[i];
                if (value instanceof String) {
                    // 对于字符串类型，使用LIKE，并自动添加%通配符
                    String likeValue = "%" + value.toString() + "%";
                    whereClause.append(columnName).append(" LIKE '").append(likeValue.replace("'", "''")).append("'");
                } else if (value instanceof Integer || value instanceof Long) {
                    // 对于整数类型，使用=
                    whereClause.append(columnName).append(" = ").append(value);
                }
                // 可以根据需要添加对其他数据类型的支持

                isFirstCondition = false;
            }
            // 如果value为null或空字符串，则忽略该条件
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
        String[] keys = {"applyId","applyUser","mName"};//这里是键
        Object[] values = {0,"张三",""};//这里是值
        getSQL(keys,values,"apply");//apply是表名
    }
}
