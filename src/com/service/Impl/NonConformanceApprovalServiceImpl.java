package com.service.Impl;

import com.dao.Impl.NonConformanceApprovalDaoImpl;
import com.pojo.echarts.GetString;
import com.pojo.echarts.IneligibleApplications;
import com.pojo.echarts.NonConformanceApproval;
import com.pojo.echarts.Times;
import com.service.NonConformanceApprovalService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NonConformanceApprovalServiceImpl implements NonConformanceApprovalService {

    NonConformanceApprovalDaoImpl nonConformanceApprovalDao = new NonConformanceApprovalDaoImpl();
    @Override
    public LayuiTable<NonConformanceApproval> getAll(int pages,int limits) {
        LayuiTable<NonConformanceApproval> nonConformanceApprovalLayuiTable = new LayuiTable<>();
        List<NonConformanceApproval> list = new ArrayList<>();
        ResultSet all = nonConformanceApprovalDao.getAll(pages, limits);
        String table = "select * from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding";
        int row = nonConformanceApprovalDao.getRow(table, 1);
        try {
            while (all.next()){
                NonConformanceApproval ineligibleApplications = new NonConformanceApproval();
                ineligibleApplications.setAppid(all.getInt(1));
                ineligibleApplications.setApplyTime(all.getString("applyTime"));
                ineligibleApplications.setCause(all.getString("cause"));
                ineligibleApplications.setDefined(all.getString("defined"));
                ineligibleApplications.setPharmacist(all.getString("pharmacist"));
                ineligibleApplications.setPharmacistApprove(all.getString("pharmacistApprove"));
                ineligibleApplications.setPharmacistTime(all.getString("pharmacistTime"));
                ineligibleApplications.setGoodsType(all.getString("goodsType"));
                ineligibleApplications.setMid(all.getInt(3));
                ineligibleApplications.setMname(all.getString(4));
                ineligibleApplications.setmType(all.getString("applyfailed.mType"));
                ineligibleApplications.setNumber(all.getInt("applyfailed.number"));
                ineligibleApplications.setPrice(all.getDouble("applyfailed.purchasePrice"));
                ineligibleApplications.setProductDate(all.getString("productDate"));
                ineligibleApplications.setPeoName(all.getString("applyUser"));
                ineligibleApplications.setSpecification(all.getString("d.specification"));
                ineligibleApplications.setSupplier(all.getString("d.supplier"));
                ineligibleApplications.setUnit(all.getString("unit"));
                list.add(ineligibleApplications);
            }
            nonConformanceApprovalLayuiTable.setData(list);
            nonConformanceApprovalLayuiTable.setCode(0);
            nonConformanceApprovalLayuiTable.setMsg("");
            nonConformanceApprovalLayuiTable.setCount(row);

        }catch (Exception e){
            e.printStackTrace();
        }
        return nonConformanceApprovalLayuiTable;
    }

    @Override
    public ResultData<List<Times>> getAllDay(int dayNum) {
        ResultData<List<Times>> timesResultData = new ResultData<>();
        List<Times> timesList = new ArrayList<>();
        List<String> days = StringDeal.getDay(dayNum);
        days.forEach(day->{
            Times times = new Times();
            times.setTimes(day);
            ResultSet resultSet1 = nonConformanceApprovalDao.GSPGetNum(times.getTimes());
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
        ResultSet kind = nonConformanceApprovalDao.getKind("mType", "apply");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = nonConformanceApprovalDao.getChoise01(getString.getName());
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
        ResultSet kind = nonConformanceApprovalDao.getKind("mName", "applyfailed");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = nonConformanceApprovalDao.getChoise02(getString.getName());
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
}
