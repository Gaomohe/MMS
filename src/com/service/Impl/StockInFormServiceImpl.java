package com.service.Impl;

import com.pojo.Orders;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;
import com.service.StockInFormService;
import com.util.GetTime;
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
    public int addDoStockInForm(StockInWithQuality stockInWithQuality) {
        String time = GetTime.getTime();
        int i = stockInFormDao.addStockInForm(stockInWithQuality);
        if (i>0){
            stockInWithQuality.setStockInTime(time);
            stockInWithQuality.setStorageStatus("已入库");
        }
        return stockInFormDao.addStockInForm(stockInWithQuality);
    }

    //分条件查询
    @Override
    public List<StockInForm> getStockInFormByQuery(String[] query) {
        String[] keys = {"stockInNum","rName","stockInTime"};//这里是键
        Object[] values = {query[0],query[1],query[2]};//这里是值
        String StockInForm = getSQL(keys, values, "StockInForm");//apply是表名
        return stockInFormDao.getStockInFormByQuery(StockInForm);
    }

    @Override
    public List<Orders> getManufactorWithNoRepeat() {
        int i =0;
        List<Orders> ordersList = stockInFormDao.getManufactorWithNoRepeat();
        for (Orders orders : ordersList){
            orders.setoId(i);
            i++;
        }
        return ordersList;
    }

    @Override
    public LayuiTable<StockInWithQuality> getStockInFormByManufactorAndDrugName(int page, int limit,String manufactor,String rName) {
        int curePage = (page-1)*limit;
        List<StockInWithQuality> drugNameByManufactor = stockInFormDao.getStockInFormByManufactorAndDrugName(curePage, limit,manufactor,rName);
        LayuiTable<StockInWithQuality> LayuiTable = new LayuiTable<StockInWithQuality>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockInFormDao.getStockInFormByManufactorAndDrugName().size());
        LayuiTable.setData(drugNameByManufactor);
        return LayuiTable;
    }

    @Override
    public LayuiTable<StockInWithQuality> getAllStockForm(int page, int limit) {
        int curePage = (page-1)*limit;
        List<StockInWithQuality> drugNameByManufactorName = stockInFormDao.getAllStockForm(curePage, limit);
        LayuiTable<StockInWithQuality> LayuiTable = new LayuiTable<StockInWithQuality>();
        LayuiTable.setMsg("");
        LayuiTable.setCode(0);
        LayuiTable.setCount(stockInFormDao.getAllStockForm().size());
        LayuiTable.setData(drugNameByManufactorName);
        return LayuiTable;
    }
}
