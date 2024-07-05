package com.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class GetTime {

    public static String getTime() {
        // 使用DateTimeFormatter定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 格式化当前时间
        return now.format(formatter);
    }
}
