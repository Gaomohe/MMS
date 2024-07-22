package com.dao;

import java.sql.ResultSet;

public interface PharmaceuticalSalesDao {
    public ResultSet getAll(int pages, int limits);
    public ResultSet GSPGetNum(String time);

    public ResultSet getChoise01(String unit);

    public ResultSet  getChoise02(String mName);

    public ResultSet getKind01();
    public ResultSet getKind02();
}
