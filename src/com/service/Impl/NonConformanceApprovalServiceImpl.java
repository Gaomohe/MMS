package com.service.Impl;

import com.dao.Impl.NonConformanceApprovalDaoImpl;
import com.pojo.echarts.IneligibleApplications;
import com.pojo.echarts.NonConformanceApproval;
import com.service.NonConformanceApprovalService;
import com.util.LayuiTable;

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
}
