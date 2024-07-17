package com.dao;

import com.util.ResultData;

import java.sql.ResultSet;

public interface ApprovalDao {
    public boolean isok(int id,String userName);

    public boolean nook(int id,String userName);

    public boolean noaudit(int id,String name);



}
