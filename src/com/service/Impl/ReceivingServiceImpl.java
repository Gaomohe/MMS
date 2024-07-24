package com.service.Impl;

import com.dao.Impl.ReceivingDaoImpl;
import com.pojo.StockInForm;
import com.pojo.echarts.GSPSupply;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.ReceivingService;
import com.util.JDBC;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceivingServiceImpl implements ReceivingService {
    ReceivingDaoImpl receivingDao = new ReceivingDaoImpl();

    @Override
    public ResultData<List<Times>> getAll(int dayNum) {
        ResultData<List<Times>> timesResultData = new ResultData<>();
        List<Times> timesList = new ArrayList<>();
        List<String> days = StringDeal.getDay(dayNum);
        days.forEach(day->{
            Times times = new Times();
            times.setTimes(day);
            ResultSet resultSet1 = receivingDao.GSPGetNum(times.getTimes());
            try {
                if (resultSet1.next()){
                    times.setNumber(resultSet1.getInt(1));
                }
                timesList.add(times);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        timesResultData.setStatus(200);
        timesResultData.setData(timesList);
        timesResultData.setMsg("");


        return timesResultData;
    }

    @Override
    public ResultData<List<GetString>> getChoise01() {
        ResultSet kind = receivingDao.getKind("unit", "stockinform");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = receivingDao.getChoise01(getString.getName());
                if (allSup.next()){
                    getString.setNumber(allSup.getInt(1));
                }
                gspSupplies.add(getString);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData<List<GetString>> getChoise02() {
        ResultSet kind = receivingDao.getKind("rName", "stockinform");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = receivingDao.getChoise02(getString.getName());
                if (allSup.next()){
                    getString.setNumber(allSup.getInt(1));
                }
                gspSupplies.add(getString);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public LayuiTable<StockInForm> search(String[] key, String[] value) {
        LayuiTable<StockInForm> stockInFormLayuiTable = new LayuiTable<>();
        ResultSet resultSet = receivingDao.search(key, value, "stockinform");
        List<StockInForm> stockInFormList = new ArrayList<>();
        int count = 0;
        try {
            ResultSet userDaoAll = receivingDao.getAll("stockinform");
            while (userDaoAll.next()){
                count++;
            }
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setStockInNum(resultSet.getString(2));
                stockInForm.setTableCoding(resultSet.getInt(3));
                stockInForm.setrName(resultSet.getString(4));
                stockInForm.setStandard(resultSet.getString(5));
                stockInForm.setManufactor(resultSet.getString(6));
                stockInForm.setUnit(resultSet.getString(7));
                stockInForm.setrNum(resultSet.getInt(8));
                stockInForm.setCost(resultSet.getInt(9));
                stockInForm.setSalePrice(resultSet.getInt(10));
                stockInForm.setBatchNumber(resultSet.getString(11));
                stockInForm.setProductDate(resultSet.getString(12));
                stockInForm.setExpiration(resultSet.getString(13));
                stockInForm.setStockInTime(resultSet.getString(14));
                stockInForm.setDepartment(resultSet.getString(15));
                stockInForm.setNotes(resultSet.getString(16));
                stockInFormList.add(stockInForm);
            }

            stockInFormLayuiTable.setCount(count);
            stockInFormLayuiTable.setCode(0);
            stockInFormLayuiTable.setMsg("");
            stockInFormLayuiTable.setData(stockInFormList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormLayuiTable;
    }

}
