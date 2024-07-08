package com.dao;

import com.pojo.Sub_Apply;

import java.sql.ResultSet;

public interface ShoppingDao {
    //
    public ResultSet likeSelect(String like);

    public boolean addSub_Apply(Sub_Apply sub_apply);

    //生成转存表
    public ResultSet memoryList();

    //生成转存表2
    public ResultSet subApplyList();
}
