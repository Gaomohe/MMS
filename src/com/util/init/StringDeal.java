package com.util.init;

public class StringDeal {
    //主要用来处理字符串

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
}
