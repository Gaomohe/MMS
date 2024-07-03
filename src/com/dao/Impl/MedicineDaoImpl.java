package com.dao.Impl;

import com.dao.MedicineDao;
import com.pojo.Medicine;

public class MedicineDaoImpl implements MedicineDao {
    @Override
    public int addMedicine(Medicine medicine) {
        /*String sql = "INSERT INTO `dictionary`\n" +
                "(\n" +
                "`mName`,`specification`,`manufactor`,`unit`,`department`,`position`,`number`,`batchNumber`,\n" +
                "`usefulLife`,`purchasePrice`,`salePrice`,`productDate`,`profits`,`code`,`goodsType`,`mType`,\n" +
                "`defined`,`supplier`,`warehousingDate`,`locationDescription`,`sign`,`warehousingRemarks`,`drugFrom`,\n" +
                "`handlingInformation`,`approvalNumber`,`LastCuringDate`,`timesStorage`,`documentNumber`,`placeOrigin`,\n" +
                "`batchsNumber`,`recordNumber`\n" +
                ")\n" +
                "VALUES \n" +
                "(\n" +
                "?,?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,\n" +
                "?,?\n" +
                ")";
        Object[] objects= new Object[31];
        objects[0] = medicine.getmName();

        int count= JDBC.update(sql,objects);*/
        return 0;
    }

    @Override
    public int delMedicine(int mId) {
        return 0;
    }

    @Override
    public int updateMedicinePrice(Medicine medicine) {
        return 0;
    }
}
