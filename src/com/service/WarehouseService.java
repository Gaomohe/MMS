package com.service;

import com.pojo.User;
import com.pojo.Warehouse;

import java.util.List;

public interface WarehouseService {
    public List<Warehouse> getWarehouseList();
    public Warehouse getWarehouseById(int mid);
    public int deWarehouseById(int id);
    public int updateDoWarehouse(Warehouse warehouse);
    public int addDoWarehouse(Warehouse warehouse);
}
