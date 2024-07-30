package com.service;

public interface FirstPageService {
    //获取未处理退货单数量
    public int getReturnNumber();
    //获取为审阅不合格品数量
    public int getFailedNumber();
    //获取所有未付款药品数量
    public int getUnPayed();
}