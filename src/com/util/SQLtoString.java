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

            if (value != null) {
                if (!isFirstCondition) {
                    whereClause.append(" AND ");
                }

                String columnName = key[i];
                if (value instanceof String) {
                    String likeValue = "%" + value.toString() + "%"; // 注意：这里总是添加%
                    whereClause.append(columnName).append(" LIKE '").append(likeValue.replace("'", "''")).append("'");
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
        String[] keys = {"applyId","applyUser","mName"};//这里是键
        Object[] values = {"","%张三%",""};//这里是值
        getSQL(keys,values,"apply");//apply是表名
    }
}
