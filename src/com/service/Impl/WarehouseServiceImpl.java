package com.service.Impl;

import com.dao.Impl.WarehouseDaoImpl;
import com.dao.WarehouseDao;
import com.pojo.Warehouse;
import com.service.WarehouseService;

import java.util.List;

import static com.util.Vessel.warehouseDao;

public class WarehouseServiceImpl implements WarehouseService {
    //查询全部库存
    @Override
    public List<Warehouse> getWarehouseList() {
        return warehouseDao.selectWarehouse();
    }
    //按药品id查询库存
    @Override
    public Warehouse getWarehouseById(int mid) {
        return warehouseDao.getWarehouseById(mid);
    }
    //按药品id删除库存
    @Override
    public int deWarehouseById(int id) {
        return warehouseDao.delWarehouse(id);
    }
    //修改药品库存
    @Override
    public int updateDoWarehouse(Warehouse warehouse) {
        return warehouseDao.updateWarehouse(warehouse);
    }
    //添加药品库存
    @Override
    public int addDoWarehouse(Warehouse warehouse) {
        return warehouseDao.addWarehouse(warehouse);
    }
}
