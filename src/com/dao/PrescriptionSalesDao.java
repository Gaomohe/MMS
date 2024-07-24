package com.dao;

import java.sql.ResultSet;

public interface PrescriptionSalesDao {
    public ResultSet getAll(int pages, int limits);

    public ResultSet GSPGetNum(String time);

    public ResultSet getChoise01(String unit);

    public ResultSet  getChoise02(String mName);

    public ResultSet getKing01();
    public ResultSet getKing02();

    public ResultSet getAll(String sql);
}
