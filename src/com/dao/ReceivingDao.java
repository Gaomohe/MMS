package com.dao;

import java.sql.ResultSet;

public interface ReceivingDao {
    public ResultSet getAllSup(String supply);

    public ResultSet GSPGetNum(String time);

    public ResultSet getChoise01(String unit);

    public ResultSet  getChoise02(String mName);
}
