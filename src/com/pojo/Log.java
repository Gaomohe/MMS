package com.pojo;

import lombok.Data;

@Data
public class Log {
    private int logId;
    private String time;
    private String name;
    private String action;
    private String item;
    private String operate;
}
