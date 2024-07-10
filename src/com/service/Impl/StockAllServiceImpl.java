package com.service.Impl;

import com.pojo.StockAllForm;
import com.service.StockAllService;
import com.util.LayuiTable;

import java.util.List;

import static com.util.Vessel.stockAllDao;

public class StockAllServiceImpl implements StockAllService {
    //查询全部库存
    @Override
    public List<StockAllForm> getStockAllFormList() {
        return stockAllDao.selectStockAllForm();
    }

    @Override
    public LayuiTable<StockAllForm> selectStockAllForm(int page, int limit) {
        int curePage = (page-1)*limit;
        List<StockAllForm> stockAllFormList = stockAllDao.selectStockAllForm(curePage, limit);
        LayuiTable<StockAllForm> LayuiTable = new LayuiTable<StockAllForm>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockAllDao.selectStockAllForm().size());
        LayuiTable.setData(stockAllFormList);
        return LayuiTable;
    }

    //按药品id查询库存
    @Override
    public StockAllForm getStockAllFormById(int mid) {
        return stockAllDao.getStockAllFormById(mid);
    }
    //按药品id删除库存
    @Override
    public int delStockAllFormById(int id) {
        return stockAllDao.delStockAllForm(id);
    }
    //修改药品库存
    @Override
    public int updateDoStockAllForm(StockAllForm stockAllForm) {
        return stockAllDao.updateStockAllForm(stockAllForm);
    }
    //添加药品库存
    @Override
    public int addDoStockAllForm(StockAllForm stockAllForm) {
        return stockAllDao.addStockAllForm(stockAllForm);
    }
}
