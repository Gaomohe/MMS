package com.service.Impl;

import com.dao.Impl.PrescriptionSalesDaoImpl;
import com.pojo.echarts.Sale;
import com.service.PrescriptionSalesService;
import com.util.LayuiTable;

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
}
