package com.dao;

import com.pojo.User;
import com.pojo.Warehouse;

import java.util.List;

public interface WarehouseDao {


    //查询库存所有药品
    public List<Warehouse> selectWarehouse();
    //根据药品id查询该药品的库存
    public Warehouse getWarehouseById(int mid);
    //根据药品删除该药品的库存
    public int delWarehouse(int id);
    //修改库存
    public int updateWarehouse(Warehouse warehouse);
    //增加库存
    public int addWarehouse(Warehouse warehouse);
}
