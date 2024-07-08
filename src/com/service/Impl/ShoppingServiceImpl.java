package com.service.Impl;

import com.dao.Impl.ShoppingDaoImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.pojo.Apply;
import com.pojo.Medicine;
import com.pojo.Sub_Apply;
import com.service.ShoppingService;
import com.service.UserService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.appointDao;
import static com.util.Vessel.appointService;

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
            int i = appointService.insertApply();
            System.out.println(i);
        }else {
            resultData.setStatus(500);
            resultData.setData("");
            resultData.setMsg("");

        }
        return resultData;
    }

    @Override
    public List<Medicine> memoryList() {
        List<Medicine> medicineList = new ArrayList<>();
        ResultSet resultSet = shoppingDao.memoryList();
        try{
            while (resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt(1));
                medicine.setmName(resultSet.getString(2));
                medicine.setSpecification(resultSet.getString(3));
                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString(5));
                medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));
                medicine.setNumber(resultSet.getInt(8));
                medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getDouble(11));
                medicine.setSalePrice(resultSet.getDouble(12));
                medicine.setProductDate(resultSet.getString(13));
                medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));
                medicine.setGoodsType(resultSet.getString(16));
                medicine.setmType(resultSet.getString(17));
                medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));
                medicine.setDrugFrom(resultSet.getString(24));
                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString(26));
                medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));
                medicine.setTableCoding(resultSet.getInt(33));
                medicineList.add(medicine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicineList;
    }

    @Override
    public List<Apply> subApplyList() {
        List<Apply> applyList = new ArrayList<>();
        ResultSet resultSet = shoppingDao.subApplyList();
        int name = 0;
        try{
            while (resultSet.next()){
                Apply apply = new Apply();
                apply.setmId(resultSet.getInt(2));
                apply.setApplyNumber(resultSet.getInt(3));
                apply.setApplyTime(resultSet.getString(4));
                UserService userService = new UserServiceImpl();
                apply.setApplyUser(userService.getName(resultSet.getInt(5)));
                apply.setPharmacistApprove(resultSet.getString(6));
                apply.setFinance(resultSet.getString(6));
                applyList.add(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return applyList;
    }
}
