package com.service.Impl;

import com.pojo.Orders;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;
import com.pojo.User;
import com.service.StockInFormService;
import com.util.JDBC;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.qualityService;
import static com.util.Vessel.stockInFormDao;

public class StockInFormServiceImpl implements StockInFormService {
    //查询所有入库单
    @Override
    public List<StockInForm> getStockInFormList() {
        return stockInFormDao.selectStockInForm();
    }
    //分页查询所有入库单
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
    //按入库单号查询
    @Override
    public StockInForm getStockInFormById(int id) {
        return stockInFormDao.getStockInFormById(id);
    }
    //删除入库单
    @Override
    public int delStockInFormById(int id) {
        return stockInFormDao.delStockInForm(id);
    }
    //更新入库单
    @Override
    public int updateDoStockInForm(StockInForm stockInForm) {
        return stockInFormDao.updateStockInForm(stockInForm);
    }
    //新增入库单
    @Override
    public int addDoStockInForm(StockInWithQuality stockInWithQuality,String name, User user) {
        int i = qualityService.updateQualitySS(stockInWithQuality.getId(), name, user);
        if (i==0){
            return i;
        }
        return stockInFormDao.addStockInForm(stockInWithQuality);
    }

    //根据入库单号，药品名称，入库日期模糊查询
    @Override
    public List<StockInForm> getStockInFormByQuery(String[] query) {
        String[] keys = {"stockInNum","rName","stockInTime"};//这里是键
        Object[] values = {query[0],query[1],query[2]};//这里是值
        String StockInForm = getSQL(keys, values, "StockInForm");//apply是表名
        return stockInFormDao.getStockInFormByQuery(StockInForm);
    }
    //获得订单表里所有供应商名称
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
    //通过供应商或药品名称查询出对应的入库单（入库单表+质量检测表）
    public LayuiTable<StockInWithQuality> getStockInFormByManufactorOrDrugName(int page,int limit,String manufactor,String rName,String[] query) {
        String sql1 = "(SELECT\n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber,\n" +
                "    q.statue,\n" +
                "    q.storageStatus,\n" +
                "    q.id\n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0 )\n" +
                "AS a " ;
        String[] keys = {"manufactor","rName"};//这里是键
        Object[] values = {manufactor,rName};//这里是值
        String sql2 = getSQL(keys, values,sql1) ;
        //添加limit子句
        List<StockInWithQuality> list = stockInFormDao.getStockInWithQualityByQuery(sql2,page,limit);
        LayuiTable<StockInWithQuality> layuiTable = new LayuiTable<StockInWithQuality>();
        layuiTable.setData(list);
        layuiTable.setCode(0);
        layuiTable.setCount(list.size());
        return layuiTable;
    }
    //展示所有入库单
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
