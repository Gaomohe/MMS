package com.service.Impl;

import com.pojo.NormalStockOut;
import com.pojo.StockInForm;
import com.pojo.StockOutForm;
import com.service.StockInFormService;
import com.service.StockOutFormService;
import com.util.LayuiTable;

import java.util.List;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.stockInFormDao;
import static com.util.Vessel.stockOutFormDao;

public class StockOutFormServiceImpl implements StockOutFormService {
    @Override
    public List<StockOutForm> getStockOutFormList() {
        return stockOutFormDao.selectStockOutForm();
    }

    @Override
    public LayuiTable<StockOutForm> selectStockOutForm(int page, int limit) {
        int curePage = (page-1)*limit;
        List<StockOutForm> stockOutForms = stockOutFormDao.selectStockOutForm(curePage, limit);
        LayuiTable<StockOutForm> LayuiTable = new LayuiTable<StockOutForm>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockOutFormDao.selectStockOutForm().size());
        LayuiTable.setData(stockOutForms);
        return LayuiTable;
    }

    @Override
    public StockOutForm getStockOutFormById(int id) {
        return stockOutFormDao.getStockOutFormById(id);
    }

    @Override
    public int delStockOutFormById(int id) {
        return stockOutFormDao.delStockOutForm(id);
    }

    @Override
    public int updateDoStockOutForm(StockOutForm stockOutForm) {
        return stockOutFormDao.updateStockOutForm(stockOutForm);
    }

    @Override
    public LayuiTable<NormalStockOut> getNormalStockOut(int page, int limit) {
        int curePage = (page-1)*limit;
        List<NormalStockOut> normalStockOut = stockOutFormDao.getNormalStockOut(curePage, limit);
        LayuiTable<NormalStockOut> LayuiTable = new LayuiTable<NormalStockOut>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockOutFormDao.getNormalStockOut().size());
        LayuiTable.setData(normalStockOut);
        return LayuiTable;
    }

    @Override
    public List<StockOutForm> getStockOutFormByQuery(String[] query) {
        String[] keys = {"outNum","oName","stockOutTime"};//这里是键
        Object[] values = {query[0],query[1],query[2]};//这里是值
        String stockOutForm = getSQL(keys, values, "StockOutForm");//apply是表名
        return stockOutFormDao.getStockOutFormByQuery(stockOutForm);
    }

//    @Override
//    public int addDoStockOutForm(StockOutForm stockOutForm) {
//        return stockOutFormDao.addStockOutForm(stockOutForm);
//    }
}
