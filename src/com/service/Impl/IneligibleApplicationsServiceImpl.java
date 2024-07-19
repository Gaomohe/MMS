package com.service.Impl;

import com.dao.Impl.IneligibleApplicationsDaoImpl;
import com.pojo.Medicine;
import com.pojo.echarts.IneligibleApplications;
import com.service.IneligibleApplicationsService;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IneligibleApplicationsServiceImpl implements IneligibleApplicationsService {
    IneligibleApplicationsDaoImpl ineligibleApplicationsDao = new IneligibleApplicationsDaoImpl();
    LayuiTable<IneligibleApplications> ineligibleApplicationsLayuiTable = new LayuiTable<>();
    @Override
    public LayuiTable<IneligibleApplications> getAll(int pages, int limits) {
        List<IneligibleApplications> list = new ArrayList<>();
        ResultSet all = ineligibleApplicationsDao.getAll(pages, limits);
        String table = "select * from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding";
        int row = ineligibleApplicationsDao.getRow(table, 1);
        try {
            while (all.next()){
                IneligibleApplications ineligibleApplications = new IneligibleApplications();
                ineligibleApplications.setAppid(all.getInt(1));
                ineligibleApplications.setApplyTime(all.getString("applyTime"));
                ineligibleApplications.setCause(all.getString("cause"));
                ineligibleApplications.setDefined(all.getString("defined"));
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
            ineligibleApplicationsLayuiTable.setData(list);
            ineligibleApplicationsLayuiTable.setCode(0);
            ineligibleApplicationsLayuiTable.setMsg("");
            ineligibleApplicationsLayuiTable.setCount(row);

        }catch (Exception e){
            e.printStackTrace();
        }
        return ineligibleApplicationsLayuiTable;
    }
}
