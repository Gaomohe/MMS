package com.dao.Impl;

import com.dao.PharmacyDao;
import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.medicineCount;

public class PharmacyDaoImpl implements PharmacyDao {
    //获取处方列表
    @Override
    public List<Pharmacy> getPharmacyList(int page, int limit) {
        String sql = "select orderId,pId,name,dName,diagnosticTime from patient\n" +
                "inner join medicineorder on patient.mId = medicineorder.orderId\n" +
                "where medicineorder.status='未取药'\n" +
                "group by orderId,pId,name,dName,diagnosticTime;";
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        List<Pharmacy> pharmacyList = new ArrayList<Pharmacy>();
        try{
            while (resultSet.next()) {
                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setPhId(resultSet.getInt("orderId"));
                pharmacy.setpId(resultSet.getInt("pId"));
                pharmacy.setpName(resultSet.getString("name"));
                pharmacy.setDoctor(resultSet.getString("dName"));
                pharmacy.setTime(resultSet.getString("diagnosticTime"));
                pharmacyList.add(pharmacy);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pharmacyList;
    }

    //获取处方中是否含有处方药
    @Override
    public boolean isPharmacy(Pharmacy pharmacy) {
        String sql = "select defined from dictionary\n" +
                "where defined='处方药' and mId in (\n" +
                "    select mId from medicineorder\n" +
                "where orderId = ?\n" +
                "    )\n" +
                "group by defined";
        Object[] objects = new Object[1];
        objects[0] = pharmacy.getPhId();
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Pharmacy> pharmacyList = new ArrayList<>();
        boolean isPharmacy = false;
        String isPharmacy1 = "";
        try{
            while (resultSet.next()) {
                isPharmacy1 = resultSet.getString("defined");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        isPharmacy = (isPharmacy1.equals("处方药"));
        return isPharmacy;
    }

    @Override
    public int getpId(int phId) {
        String sql = "select pId from morder\n" +
                "where orderId = ?;";
        Object[] objects = new Object[1];
        objects[0] = phId;
        ResultSet resultSet = JDBC.select(sql,objects);
        int pId = 0;
        try{
            while (resultSet.next()) {
                pId = resultSet.getInt("pId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pId;
    }

    //获取处方中的具体药品
    @Override
    public List<Medicine> checkPharmacy(int phId, int page, int limit) {
        String sql = "select * from dictionary\n" +
                "left join medicineorder on dictionary.mId = medicineorder.mId\n" +
                "where orderId = ? and status = '未取药'\n" +
                "limit ?,?;";
        Object[] objects = new Object[3];
        objects[0] = phId;
        objects[1] = page;
        objects[2] = limit;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Medicine> medicines = new ArrayList<>();
        try {
            while (resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt("mId"));
                medicine.setmName(resultSet.getString("mName"));
                medicine.setSpecification(resultSet.getString("specification"));
//                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString("unit"));
                /*medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));*/
                medicine.setNumber(resultSet.getInt("number"));
                /*medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));*/
                medicine.setSalePrice(resultSet.getInt("salePrice"));
                medicine.setProductDate(resultSet.getString("productDate"));
                /*medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));*/
                medicine.setGoodsType(resultSet.getString("goodsType"));
                medicine.setmType(resultSet.getString("mType"));
                medicine.setDefined(resultSet.getString("defined"));
                /*medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));*/
                medicine.setDrugFrom(resultSet.getString("drugFrom"));
//                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString("approvalNumber"));
                /*medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));*/
                medicine.setTableCoding(resultSet.getInt("tableCoding"));
                medicines.add(medicine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }

    //患者取药
    @Override
    public int getMedicine(int mId, int pId) {
        String sql = "update dic_num\n" +
                "set statue = '已付款',time = NOW()\n" +
                "where tableCoding = ? and patientId = ?";
        Object[] objects = new Object[2];
        objects[0] = mId;
        objects[1] = pId;
        int result = JDBC.update(sql,objects);
        return result;
    }

    @Override
    public int getMedicine1(int mId, int phId) {
        String sql = "update medicineorder\n" +
                "set status = '已取药'\n" +
                "where mId = ? and orderId = ?;";
        Object[] objects = new Object[2];
        objects[0] = mId;
        objects[1] = phId;
        int result = JDBC.update(sql,objects);
        return result;
    }
}
