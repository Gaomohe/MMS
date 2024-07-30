package com.service;

import com.pojo.FirstPage;
import com.pojo.Orders;

import java.util.List;

public interface FirstPageService {
    //获取未处理退货单数量
    public int getReturnNumber();
    //获取为审阅不合格品数量
    public int getFailedNumber();
    //获取所有未付款药品数量
    public int getUnPayed();
    //获取右边的预警公告内容
    public List<FirstPage> getWarnMsg();
    public List<Orders> getOrderMsg();
}