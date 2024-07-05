package com.service;

import com.pojo.Medicine;
import com.pojo.Supplier;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.List;

public interface ShoppingService {
    //
    public LayuiTable<Medicine> getAll(int page,int limit);

    //
    public List<Medicine> getKind();

    //
    public LayuiTable<Medicine> getSelectedValue(String where);

    public LayuiTable<Medicine> getSelectedTime(String where);

    //
    public LayuiTable<Medicine> likeSelect(String like);


}
