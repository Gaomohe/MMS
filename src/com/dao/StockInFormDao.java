package com.dao;

import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;

import java.util.List;

public interface StockInFormDao {
    //查询全部入库单
    public List<StockInForm> selectStockInForm();
    //按id查询入库单
    public StockInForm getStockInFormById(int id);
    //分页
    public List<StockInForm> selectStockInForm(int page, int limit);
    //删除入库单
    public int delStockInForm(int id);
    //更新入库单
    public int updateStockInForm(StockInForm stockInForm);
    //添加入库单
    public int addStockInForm(StockInWithQuality stockInWithQuality);

    //根据入库单号，药品名称，入库日期区间查询
    public List<StockInForm> getStockInFormByQuery(String sql);

    //查询所有生产厂家并排除重复
    public List<StockInForm> getManufactorWithNoRepeat();
    //根据质量检测表查询有哪些药品是要入库的
    public List<StockInWithQuality> getDrugNameByManufactor(int page, int limit);
    //获取上面这个表的长度
    public List<StockInWithQuality> getDrugNameByManufactor();
    public List<StockInWithQuality> getDrugNameByManufactorName(int page, int limit,String manufactorName);
    //获取上面这个表的长度
    public List<StockInWithQuality> getDrugNameByManufactorName();
}
