package com.service;

import com.pojo.Medicine;
import com.pojo.User;

import java.util.List;

public interface MedicineService {
    //药品增加
    public int addMedicine(Medicine medicine);
    //药品删除
    public int delMedicine(int tableCoding);
    //根据药品编号删除药品
    public int delMedicineByMId(int mId);
    //药品价格修改
    public int updateMedicinePrice(Medicine medicine);
    //药品养护日期修改
    public int updateMedicineLastCuringDate(int tableCoding);
    //药品入库时间修改
    public int updateMedicineWarehousingDate(Medicine medicine);
    //药品基本信息修改
    public int updateMedicineBasic(Medicine medicine);
    //全部查询
    public List<Medicine> getAllMedicine(int index,int limit);
    public List<Medicine> getAllMedicine(int index,int limit,String type,String title);
    public int getAllMedicine();
    //药品回显
    public Medicine getMedicine(int tableCoding);
    //根据名字模糊查询药品
    public List<Medicine> getMedicine(String mName);
    //多条件查询单轮（药品名称，商品分类，药品功效，剂型）
    public List<Medicine> getMedicineByQuery(String[] query);
    //多条件查询多轮（药品名称，商品分类，药品功效，剂型）
    public List<Medicine> getMedicineByQuerys(String[] query1,String[] query2,String[] query3,String[] query4);
    //根据药品编码显示一条药品的数据
    public List<Medicine> getMedicineByMId(int mId);
    //新增库存维护表
    public int addDic_Num(int tableCoding,int number,int patientId);
    //改变维护表状态
    public int updateDic_Num(int tableCoding,int patirntId);
    //药品库存数量修改
    public int updateMedicineNumber(Medicine medicine,int num,int patientId);
    //售出药品
    public String delDic_Num(int tableCoding, int number, int patientId, User user);
    //实现库存回滚
    public int rollBack(int pId);
}
