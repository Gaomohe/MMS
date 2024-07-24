package com.service.Impl;

import com.dao.Impl.PrescriptionSalesDaoImpl;
import com.pojo.StockInForm;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Sale;
import com.pojo.echarts.Times;
import com.service.PrescriptionSalesService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionSalesServiceImpl implements PrescriptionSalesService {
    PrescriptionSalesDaoImpl prescriptionSalesDao = new PrescriptionSalesDaoImpl();
    @Override
    public LayuiTable<Sale> getAll(int pages, int limits) {
        String table = "select * from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药'";
        int row = prescriptionSalesDao.getRow(table, 1);
        LayuiTable<Sale> saleLayuiTable = new LayuiTable<>();
        ResultSet all = prescriptionSalesDao.getAll(pages, limits);
        List<Sale> list = new ArrayList<>();

        try {
            while (all.next()){
                Sale sale = new Sale();
                sale.setOrder(all.getInt(2));
                sale.setMid(all.getInt(1));
                sale.setName(all.getString("mName"));
                sale.setSpecification(all.getString("specification"));
                sale.setUnit(all.getString("unit"));
                sale.setDepartment(all.getString("department"));
                sale.setNumber(all.getInt("dic.number"));
                sale.setSalenumber(all.getInt(4));
                sale.setSalePrice(all.getDouble("salePrice"));
                sale.setProductDate(all.getString("productDate"));
                sale.setGoodsType(all.getString("goodsType"));
                sale.setmType(all.getString("mType"));
                sale.setDefined(all.getString("defined"));
                sale.setSupplier(all.getString("supplier"));
                sale.setDrugFrom(all.getString("drugFrom"));
                sale.setDocumentNumber(all.getString("documentNumber"));
                list.add(sale);
            }
            saleLayuiTable.setData(list);
            saleLayuiTable.setMsg("");
            saleLayuiTable.setCode(0);
            saleLayuiTable.setCount(row);

        }catch (Exception e){
            e.printStackTrace();
        }
        return saleLayuiTable;
    }

    @Override
    public ResultData<List<Times>> getAllDay(int dayNum) {
        ResultData<List<Times>> timesResultData = new ResultData<>();
        List<Times> timesList = new ArrayList<>();
        List<String> days = StringDeal.getDay(dayNum);
        days.forEach(day->{
            Times times = new Times();
            times.setTimes(day);
            ResultSet resultSet1 = prescriptionSalesDao.GSPGetNum(times.getTimes());
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
        ResultSet kind = prescriptionSalesDao.getKing01();
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = prescriptionSalesDao.getChoise01(getString.getName());
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
        ResultSet kind = prescriptionSalesDao.getKing02();
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = prescriptionSalesDao.getChoise02(getString.getName());
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
    public LayuiTable<Sale> search(String[] key, String[] value) {
        LayuiTable<Sale> saleLayuiTable = new LayuiTable<>();
        String table = "select * from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药'";
        ResultSet all = prescriptionSalesDao.searchCustomize(key, value, table, 1);
        List<Sale> Sale = new ArrayList<>();
        int row = prescriptionSalesDao.getRow(table, 1);
        try {

            while (all.next()){
                Sale sale = new Sale();
                sale.setOrder(all.getInt(2));
                sale.setMid(all.getInt(1));
                sale.setName(all.getString("mName"));
                sale.setSpecification(all.getString("specification"));
                sale.setUnit(all.getString("unit"));
                sale.setDepartment(all.getString("department"));
                sale.setNumber(all.getInt("dic.number"));
                sale.setSalenumber(all.getInt(4));
                sale.setSalePrice(all.getDouble("salePrice"));
                sale.setProductDate(all.getString("productDate"));
                sale.setGoodsType(all.getString("goodsType"));
                sale.setmType(all.getString("mType"));
                sale.setDefined(all.getString("defined"));
                sale.setSupplier(all.getString("supplier"));
                sale.setDrugFrom(all.getString("drugFrom"));
                sale.setDocumentNumber(all.getString("documentNumber"));
                Sale.add(sale);
            }

            saleLayuiTable.setCount(row);
            saleLayuiTable.setCode(0);
            saleLayuiTable.setMsg("");
            saleLayuiTable.setData(Sale);
        }catch (Exception e){
            e.printStackTrace();
        }
        return saleLayuiTable;
    }
}
