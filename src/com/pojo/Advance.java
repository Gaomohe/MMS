package com.pojo;

import lombok.Data;

//预付款数据
@Data
public class Advance {
    private int orderId;  //批次编号
    private String mname; //商品名称
    private String kind;  //类型
    private String specification;//规格
    private String drugFrom;  //种类
    private String supplier;//公司
    private String unit;  //商品类型
    private String productDate;  //生产日期
    private double buyPrice; //售卖价格
    private int number;   //数量
    private String percent;//比重
    private String opera; //操作人员
    private String finence;//财务人员
    private String state;   //单据状态
    private String times;   //单据时间
    private String account; //账户
}
