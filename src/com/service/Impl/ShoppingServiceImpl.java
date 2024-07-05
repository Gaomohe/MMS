package com.service.Impl;

import com.dao.Impl.ShoppingDaoImpl;
import com.pojo.Medicine;
import com.pojo.Sub_Apply;
import com.service.ShoppingService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShoppingServiceImpl implements ShoppingService {
    ShoppingDaoImpl shoppingDao = new ShoppingDaoImpl();
    LayuiTable<Medicine> layuiTable = new LayuiTable<Medicine>();
    ResultData resultData = new ResultData();

    @Override
    public LayuiTable<Medicine> getAll(int page,int limit) {
        ResultSet dictionary = shoppingDao.getAll(page,limit,"dictionary");
        ResultSet dic = shoppingDao.getAll("dictionary");
        int count = 0;
        List<Medicine> medicineList = new ArrayList<>();

        try {
            while (dic.next()){
                count++;
            }
            while (dictionary.next()){
                Medicine medicine = new Medicine();
                medicine.setTableCoding(dictionary.getInt("tableCoding"));
                medicine.setmName(dictionary.getString(2));
                medicine.setSpecification(dictionary.getString(3));
                medicine.setManufactor(dictionary.getString(4));
                medicine.setNumber(dictionary.getInt("number"));
                medicine.setPurchasePrice(dictionary.getDouble("purchasePrice"));
                medicine.setProductDate(dictionary.getString("productDate"));
                medicine.setDrugFrom(dictionary.getString("drugFrom"));
                medicineList.add(medicine);
            }
            layuiTable.setData(medicineList);
            layuiTable.setMsg("");
            layuiTable.setCount(count);
            layuiTable.setCode(0);

        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public List<Medicine> getKind() {
        List<Medicine> medicineList = new ArrayList<>();
        ResultSet kind = shoppingDao.getKind("drugFrom", "dictionary");
        try {
            while (kind.next()){
                Medicine medicine = new Medicine();
                medicine.setDrugFrom(kind.getString("drugFrom"));
                medicineList.add(medicine);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicineList;
    }

    @Override
    public LayuiTable<Medicine> getSelectedValue(String where) {
        ResultSet dictionary = shoppingDao.getOne(where, "drugFrom", "dictionary");
        List<Medicine> medicineList = new ArrayList<>();
        int count = 0;
        try {
            while (dictionary.next()){
                Medicine medicine = new Medicine();
                medicine.setTableCoding(dictionary.getInt("tableCoding"));
                medicine.setmName(dictionary.getString(2));
                medicine.setSpecification(dictionary.getString(3));
                medicine.setManufactor(dictionary.getString(4));
                medicine.setNumber(dictionary.getInt("number"));
                medicine.setPurchasePrice(dictionary.getDouble("purchasePrice"));
                medicine.setProductDate(dictionary.getString("productDate"));
                medicine.setDrugFrom(dictionary.getString("drugFrom"));
                medicineList.add(medicine);
                count++;
            }
            layuiTable.setData(medicineList);
            layuiTable.setMsg("");
            layuiTable.setCount(count);
            layuiTable.setCode(0);


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public LayuiTable<Medicine> getSelectedTime(String where) {
        ResultSet dictionary = shoppingDao.getOne(where, "productDate", "dictionary");
        List<Medicine> medicineList = new ArrayList<>();
        int count = 0;
        try {
            while (dictionary.next()){
                Medicine medicine = new Medicine();
                medicine.setTableCoding(dictionary.getInt("tableCoding"));
                medicine.setmName(dictionary.getString(2));
                medicine.setSpecification(dictionary.getString(3));
                medicine.setManufactor(dictionary.getString(4));
                medicine.setNumber(dictionary.getInt("number"));
                medicine.setPurchasePrice(dictionary.getDouble("purchasePrice"));
                medicine.setProductDate(dictionary.getString("productDate"));
                medicine.setDrugFrom(dictionary.getString("drugFrom"));
                medicineList.add(medicine);
                count++;
            }
            layuiTable.setData(medicineList);
            layuiTable.setMsg("");
            layuiTable.setCount(count);
            layuiTable.setCode(0);


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public LayuiTable<Medicine> likeSelect(String like) {
        ResultSet dictionary = shoppingDao.likeSelect(like);
        List<Medicine> medicineList = new ArrayList<>();
        int count = 0;
        try {
            while (dictionary.next()){
                Medicine medicine = new Medicine();
                medicine.setTableCoding(dictionary.getInt("tableCoding"));
                medicine.setmName(dictionary.getString(2));
                medicine.setSpecification(dictionary.getString(3));
                medicine.setManufactor(dictionary.getString(4));
                medicine.setNumber(dictionary.getInt("number"));
                medicine.setPurchasePrice(dictionary.getDouble("purchasePrice"));
                medicine.setProductDate(dictionary.getString("productDate"));
                medicine.setDrugFrom(dictionary.getString("drugFrom"));
                medicineList.add(medicine);
                count++;
            }
            layuiTable.setData(medicineList);
            layuiTable.setMsg("");
            layuiTable.setCount(count);
            layuiTable.setCode(0);


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public ResultData<Medicine> selectById(int[] ids) {
        List<Medicine> list = new ArrayList<>();
        try {
            for (int id : ids) {
                ResultSet one = shoppingDao.getOne(id, "tableCoding", "dictionary");
                if (one.next()) {
                    Medicine medicine = new Medicine();
                    medicine.setTableCoding(one.getInt("tableCoding"));
                    medicine.setmName(one.getString(2));
                    medicine.setSpecification(one.getString(3));
                    medicine.setManufactor(one.getString(4));
                    medicine.setNumber(one.getInt("number"));
                    medicine.setPurchasePrice(one.getDouble("purchasePrice"));
                    medicine.setProductDate(one.getString("productDate"));
                    medicine.setDrugFrom(one.getString("drugFrom"));
                    list.add(medicine);
                }
            }
            resultData.setMsg("");
            resultData.setData(list);
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData addSub_Apply(Sub_Apply sub_apply) {
        if (shoppingDao.addSub_Apply(sub_apply)){
            resultData.setStatus(200);
            resultData.setData("");
            resultData.setMsg("");
        }else {
            resultData.setStatus(200);
            resultData.setData("");
            resultData.setMsg("");

        }
        return resultData;
    }
}
