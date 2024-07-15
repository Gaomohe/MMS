package com.util.init;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringDeal {
    //主要用来处理字符串
//   前端------ var dataString = $.param({"array": array});

    //处理URL编码的字符串
    //格式：array%5B%5D=3&array%5B%5D=5&array%5B%5D=6
    public static int[] toArray(String str){
        String[] params = str.split("&");
        int[] numbers = new int[params.length];
        for (int i = 0; i < params.length; i++) {
            // 按=分割每个参数，获取其值
            String[] keyValue = params[i].split("=");
            numbers[i]=Integer.parseInt(keyValue[1]);
        }
        return numbers;
    }
    public static String[] toStrArray(String str){
        String[] params = str.split("&");
        String[] strings = new String[params.length];
        for (int i = 0; i < params.length; i++) {
            // 按=分割每个参数，获取其值
            String[] keyValue = params[i].split("=");
            strings[i]=keyValue[1];
        }
        return strings;
    }

    //生成随机入库单号
    public static String generateStockInNumber(String businessType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        return businessType + "-" + timestamp;
    }

    //提取出有值的数组
    public static List<String[]> getTwoNotEmpty(String[] keys,String[] values) {
        List<String> listKey = new ArrayList<>();
        List<String> listValues = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (!values[i].equals("")){
                listValues.add(values[i]);
                listKey.add(keys[i]);
            }
        }
        String[] keyList = new String[listKey.size()];
        String[] valuesList = new String[listValues.size()];
        keyList = listKey.toArray(keyList);
        valuesList = listValues.toArray(valuesList);
        List<String[]> reTwo = new ArrayList<>();
        reTwo.add(keyList);
        reTwo.add(valuesList);
        return reTwo;
    }
}
