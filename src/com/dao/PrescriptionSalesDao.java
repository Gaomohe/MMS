package com.dao;

import java.sql.ResultSet;

public interface PrescriptionSalesDao {
    public ResultSet getAll(int pages, int limits);
}
