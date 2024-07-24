package com.dao;

import com.pojo.NormalStockOut;
import com.pojo.StockInForm;
import com.pojo.StockOutForm;

import java.util.List;

public interface StockOutFormDao {
    //查询全部出库单
    public List<StockOutForm> selectStockOutForm();
    //按id查询出库单
    public StockOutForm getStockOutFormById(int id);
    //分页
    public List<StockOutForm> selectStockOutForm(int page, int limit);
    //删除出库单
    public int delStockOutForm(int id);
    //修改出库单
    public int updateStockOutForm(StockOutForm stockOutForm);
    //只看正常出库出库单
    public List<NormalStockOut> getNormalStockOut(int page, int limit);
    //获取正常出库出库单的长度
    public List<NormalStockOut> getNormalStockOut();
    //根据出库单号，药品信息，出库日期查询入库单信息
    public List<StockOutForm> getStockOutFormByQuery(String sql);
    //添加出库单
//    public int addStockOutForm(StockOutForm stockOutForm);
}
