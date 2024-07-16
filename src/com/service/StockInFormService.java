package com.service;

import com.pojo.Medicine;
import com.pojo.Quality;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;
import com.util.LayuiTable;

import java.util.List;

public interface StockInFormService {
    //查询全部入库单
    public List<StockInForm> getStockInFormList();
    //分页查询所有入库单
    public LayuiTable<StockInForm> selectStockInForm(int page, int limit);
    //按入库单号查询
    public StockInForm getStockInFormById(int id);
    //删除入库单
    public int delStockInFormById(int id);
    //更新入库单
    public int updateDoStockInForm(StockInForm stockInForm);
    //新增入库单
    public int addDoStockInForm(StockInWithQuality stockInWithQuality);

    public List<StockInForm> getStockInFormByQuery(String[] query);

    public List<StockInForm> getManufactorWithNoRepeat();

    public LayuiTable<StockInWithQuality> getDrugNameByManufactor(int page, int limit);
    //通过供应商名称查询对应的药品名称
    public LayuiTable<StockInWithQuality> getDrugNameByManufactorName(int page, int limit,String manufactor);
}
