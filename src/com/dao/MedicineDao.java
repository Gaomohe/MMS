package com.dao;

import com.pojo.Medicine;

public interface MedicineDao {
    //药品增加
    public int addMedicine(Medicine medicine);
    //药品删除
    public int delMedicine(int mId);
    //药品价格修改
    public int updateMedicinePrice(Medicine medicine);

}
