package com.util.init;

import java.text.SimpleDateFormat;
import java.util.Date;

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

//    //生成随机入库单号
//    public static String generateStockInNumber(String businessType) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = simpleDateFormat.format(new Date(System.currentTimeMillis()));
//        return businessType + "-" + timestamp;
//    }
}
