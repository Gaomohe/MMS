package com.util.init;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    //获取前几天
    public static List<String> getDay(int n){
        LocalDate today = LocalDate.now(); // 获取当前日期
        List<String> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 设置日期格式
        for (int i = n; i >= 1; i--) {
            LocalDate date = today.minusDays(i); // 获取过去第i天的日期
            String dateString = date.format(formatter); // 将日期转换为字符串
            list.add(dateString);
        }
            return list;
    }

    public static long getNowTimes(){
        // 获取当前时间
        Date currentDate = new Date();

        // 创建一个日期格式化对象，设置格式为年月日时分秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        // 将当前时间格式化为字符串
        String formattedDate = dateFormat.format(currentDate);

        // 打印格式化后的日期字符串
        System.out.println("格式化的日期：" + formattedDate);

        // 如果需要将日期转换为整数，可以去掉格式化字符串中的分隔符
        SimpleDateFormat dateFormatToInt = new SimpleDateFormat("yyyyMMddHHmmss");
        return Long.parseLong(dateFormatToInt.format(currentDate));
    }
}
