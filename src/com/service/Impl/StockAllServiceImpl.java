package com.service.Impl;

import com.dao.Impl.StockAllDaoImpl;
import com.pojo.StockAllForm;
import com.service.StockAllService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.SQLtoString.getSQL;
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
    public StockAllForm getStockAllFormById(int tableCoding) {
        return stockAllDao.getStockAllFormById(tableCoding);
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

    @Override
    public List<StockAllForm> getStockInFormByQuery(String[] query) {
        String[] keys = {"goodsType","mType","supplier","drugFrom"};//这里是键
        Object[] values = {query[0],query[1],query[2],query[3]};//这里是值
        String dictionary = getSQL(keys, values, "dictionary");//apply是表名
        return stockAllDao.getStockAllFormByQuery(dictionary);
    }

    @Override
    public List<StockAllForm> getStockAllFormByDrugName(String[] query) {
        String[] keys = {"mName"};//这里是键
        Object[] values = {query[0]};//这里是值
        String dictionary = getSQL(keys, values, "dictionary");//apply是表名
        return stockAllDao.getStockAllFormByQuery(dictionary);
    }

    @Override
    public ResultData<List<StockAllForm>> getStockAllFormEChart() {
        ResultData<List<StockAllForm>> resultData = new ResultData<List<StockAllForm>>();
        StockAllDaoImpl stockAllDao = new StockAllDaoImpl();
        ResultSet kind = stockAllDao.getKind("department", "dictionary");
        List<StockAllForm> stockAllForms = new ArrayList<StockAllForm>();
        try{
            while (kind.next()){
                StockAllForm stockAllForm = new StockAllForm();
                stockAllForm.setDepartment(kind.getString(1));
                ResultSet drugsNumber = stockAllDao.getDrugsNumber(stockAllForm.getDepartment());
                if (drugsNumber.next()){
                    stockAllForm.setNumber(drugsNumber.getInt(1));
                }
                stockAllForms.add(stockAllForm);
            }
            resultData.setData(stockAllForms);
            resultData.setMsg("");
            resultData.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultData;
    }
}
