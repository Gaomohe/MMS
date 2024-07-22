package com.dao;

import com.pojo.Advance;
import com.pojo.Income;
import com.pojo.Transfer;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.List;

public interface BillDao {
    public ResultSet getAllIncome();

    public ResultSet getSupply1();
    public ResultSet getSupply2();
    public ResultSet getSupply3();

    public ResultSet getFinance2();
    public ResultSet getAccount2();


    public ResultSet getAllTransfer(int page,int limit);

}
