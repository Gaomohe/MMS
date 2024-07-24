package com.service;

import com.pojo.NormalStockOut;
import com.pojo.StockInForm;
import com.pojo.StockOutForm;
import com.util.LayuiTable;

import java.util.List;

public interface StockOutFormService {
    //查询全部出库单
    public List<StockOutForm> getStockOutFormList();
    //按出库单号查询，带分页
    public LayuiTable<StockOutForm> selectStockOutForm(int page, int limit);
    //按出库单号查询
    public StockOutForm getStockOutFormById(int id);
    //删除出库单
    public int delStockOutFormById(int id);
    //更新出库单
    public int updateDoStockOutForm(StockOutForm stockOutForm);
    //只看正常出库出库单
    public LayuiTable<NormalStockOut> getNormalStockOut(int page, int limit);
    //根据出库单号，药品信息，出库日期查询入库单信息
    public List<StockOutForm> getStockOutFormByQuery(String[] query);
    //新增出库单
//    public int addDoStockOutForm(StockOutForm stockOutForm);
}
