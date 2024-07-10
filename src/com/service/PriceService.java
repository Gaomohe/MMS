package com.service;

import com.pojo.Price;

import java.util.List;

public interface PriceService {
    //添加历史价格记录
    public int addHistory(Price price);
    //查找所有历史价格
    public List<Price> getHistoryAll();
    //根据tableCoding查找历史价格
    public List<Price> getHistoryByTab(int tableCoding);
    //根据mId查找历史价格
    public List<Price> getHistoryByMid(int mId);
    //根据时间查找历史价格
    public Price getHistoryByTime(String Time);
    //根据id删除历史价格
    public int delHistoryById(int id);
}
