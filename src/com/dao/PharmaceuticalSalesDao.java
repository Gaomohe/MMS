package com.dao;

import java.sql.ResultSet;

public interface PharmaceuticalSalesDao {
    public ResultSet getAll(int pages, int limits);
}
