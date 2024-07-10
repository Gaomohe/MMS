package com.dao;

import java.sql.ResultSet;

public interface ApprovalDao {
    public boolean isok(int id,String userName);

    public boolean nook(int id,String userName);

}
