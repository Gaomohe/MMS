package com.dao;

import com.pojo.Advance;
import com.pojo.Income;
import com.util.LayuiTable;

import java.sql.ResultSet;

public interface BillDao {
    public ResultSet getAllIncome();

    public ResultSet getSupply1();
    public ResultSet getSupply2();
    public ResultSet getSupply3();

}
