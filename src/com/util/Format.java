package com.util;

import java.util.ArrayList;
import java.util.List;

public class Format {
    public static List<Integer> StringToInt(String[] stringArray) {
        // 创建一个ArrayList来存储转换后的整数
        List<Integer> intList = new ArrayList<>();

        // 遍历字符串数组，将每个字符串转换为整数并添加到整数集合中
        for (String str : stringArray) {
            // 使用Integer.parseInt将字符串转换为整数，并添加到集合中
            intList.add(Integer.parseInt(str));
        }

        // 返回转换后的整数集合
        return intList;
    }
}
