package com.service.Impl;

import com.pojo.StockInForm;
import com.service.StockInFormService;
import com.util.LayuiTable;

import java.util.List;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.stockInFormDao;

public class StockInFormServiceImpl implements StockInFormService {
    @Override
    public List<StockInForm> getStockInFormList() {
        return stockInFormDao.selectStockInForm();
    }

    @Override
    public LayuiTable<StockInForm> selectStockInForm(int page, int limit) {
        int curePage = (page-1)*limit;
        List<StockInForm> stockInFormList = stockInFormDao.selectStockInForm(curePage, limit);
        LayuiTable<StockInForm> LayuiTable = new LayuiTable<StockInForm>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockInFormDao.selectStockInForm().size());
        LayuiTable.setData(stockInFormList);
        return LayuiTable;
    }

    @Override
    public StockInForm getStockInFormById(int id) {
        return stockInFormDao.getStockInFormById(id);
    }

    @Override
    public int delStockInFormById(int id) {
        return stockInFormDao.delStockInForm(id);
    }

    @Override
    public int updateDoStockInForm(StockInForm stockInForm) {
        return stockInFormDao.updateStockInForm(stockInForm);
    }

    @Override
    public int addDoStockInForm(StockInForm stockInForm) {
        return stockInFormDao.addStockInForm(stockInForm);
    }

    @Override
    public List<StockInForm> getStockInFormByQuery(String[] query) {
        String[] keys = {"rId","rName","stockInTime"};//这里是键
        Object[] values = {query[0],query[1],query[2]};//这里是值
        String StockInForm = getSQL(keys, values, "StockInForm");//apply是表名

        return stockInFormDao.getStockInFormByQuery(StockInForm);
    }
}
