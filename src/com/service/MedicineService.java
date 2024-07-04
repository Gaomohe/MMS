package com.service;

import com.pojo.Medicine;

import java.util.List;

public interface MedicineService {
    //药品增加
    public int addMedicine(Medicine medicine);
    //药品删除
    public int delMedicine(int tableCoding);
    public int delMedicineByMId(int mId);
    //药品价格修改
    public int updateMedicinePrice(Medicine medicine);
    //药品养护日期修改
    public int updateMedicineLastCuringDate(Medicine medicine);
    //药品入库时间修改
    public int updateMedicineWarehousingDate(Medicine medicine);
    //药品库存数量修改
    public int updateMedicineNumber(Medicine medicine);
    //药品基本信息修改
    public int updateMedicineBasic(Medicine medicine);
    //全部查询
    public List<Medicine> getAllMedicine();
    //药品回显
    public Medicine getMedicine(int tableCoding);
    //多条件查询（药品名称，商品分类，药品功效，剂型）
    public List<Medicine> getMedicineByQuery(String[] query);
}