package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.MedicineDao;
import com.pojo.DicNum;
import com.pojo.Medicine;
import com.pojo.User;
import com.service.MedicineService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.warnService;

public class MedicineServiceImpl implements MedicineService {

    MedicineDao medicineDao = new MedicineDaoImpl();
    @Override
    public int addMedicine(Medicine medicine) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Medicine medicine1 = new Medicine();
        medicine1.setLastCuringDate(format);
        return medicineDao.addMedicine(medicine);
    }

    @Override
    public int delMedicine(int tableCoding) {

        return medicineDao.delMedicine(tableCoding);
    }

    @Override
    public int delMedicineByMId(int mId) {

        return medicineDao.delMedicineByMId(mId);
    }

    @Override
    public int updateMedicinePrice(Medicine medicine) {

        return medicineDao.updateMedicinePrice(medicine);
    }

    @Override
    public int updateMedicineLastCuringDate(int  tableCoding) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Medicine medicine = new Medicine();
        medicine.setTableCoding(tableCoding);
        medicine.setLastCuringDate(format);
        return medicineDao.updateMedicineLastCuringDate(medicine);
    }

    @Override
    public int updateMedicineWarehousingDate(Medicine medicine) {

        return medicineDao.updateMedicineWarehousingDate(medicine);
    }

    @Override
    public int updateMedicineBasic(Medicine medicine) {

        return medicineDao.updateMedicineBasic(medicine);
    }

    @Override
    public List<Medicine> getAllMedicine(int index, int limit) {
        int page = (index-1)*limit;

        return medicineDao.getAllMedicine(page,limit);
    }

    @Override
    public List<Medicine> getAllMedicine(int index, int limit, String type, String title) {
        int page = (index-1)*limit;
        return medicineDao.getAllMedicine(page,limit,type,title);
    }

    @Override
    public int getAllMedicine() {
        return medicineDao.getAllMedicine();
    }

    @Override
    public Medicine getMedicine(int tableCoding) {

        return medicineDao.getMedicine(tableCoding);
    }

    @Override
    public List<Medicine> getMedicine(String mName) {
        return medicineDao.getMedicine(mName);
    }

    //多条件查询单轮
    @Override
    public List<Medicine> getMedicineByQuery(String[] query) {
        int i = 0;
        String[] keys = {"goodsType","mType","defined","drugFrom"};//这里是键
        Object[] values = {query[0],query[1],query[2],query[3]};//这里是值
        String dictionary = getSQL(keys, values, "dictionary");//apply是表名
        return medicineDao.getMedicineByQuery(dictionary);
    }

    //多条件查询（多轮）
    @Override
    public List<Medicine> getMedicineByQuerys(String[] query1, String[] query2, String[] query3, String[] query4) {
        /*int i = 0;
        List<Medicine> list = new ArrayList<Medicine>();
        while (query1.length>i || query2.length>i || query3.length>i || query4.length>i){
            String[] codition = new String[4];
            if (query1.length>i){
                codition[0] = query1[i];
            }else {
                codition[0] = "%";
            }
            if (query2.length>i){
                codition[1] = query2[i];
            }else {
                codition[1] = "%";
            }
            if (query3.length>i){
                codition[2] = query3[i];
            }else {
                codition[2] = "%";
            }
            if (query4.length>i){
                codition[3] = query4[i];
            }else {
                codition[3] = "%";
            }
            List<Medicine> medicineByQuery = medicineDao.getMedicineByQuery();
            for (Medicine medicine:medicineByQuery){
                list.add(medicine);
            }
            i++;
        }*/
        return null;
    }

    //可用于价格修改时药品的回显
    @Override
    public List<Medicine> getMedicineByMId(int mId) {
        return medicineDao.getMedicineByMId(mId);
    }

    //新增库存维护表
    @Override
    public int addDic_Num(int tableCoding,int number,int patientId) {
        Medicine medicine = medicineDao.getMedicine(tableCoding);
        return medicineDao.addDic_Num(medicine,patientId,number);
    }

    //改变维护表状态
    @Override
    public int updateDic_Num(int tableCoding,int patientId) {
        DicNum dicNum = medicineDao.getDic_Num(tableCoding, patientId);
        if (dicNum.getStatue().equals("未付款")){
            dicNum.setStatue("已付款");
        }else if (dicNum.getStatue().equals("已付款")){
            dicNum.setStatue("未付款");
        }
        return medicineDao.updateDic_Num(dicNum);
    }

    //修改药品库存
    @Override
    public int updateMedicineNumber(Medicine medicine,int num,int patientId) {
        Medicine medicine2 = medicineDao.getMedicine(medicine.getTableCoding());
        int i = 0;
        if (medicine2.getNumber() >= num){
            addDic_Num(medicine.getTableCoding(),num,patientId);
            Medicine medicine1 = medicineDao.getMedicine(medicine.getTableCoding());
            medicine1.setNumber(medicine1.getNumber()-num);
            i = medicineDao.updateMedicineNumber(medicine1);
        }
        return i;
    }

    public String delDic_Num(int tableCoding, int number, int patientId, User user){
        DicNum dicNum = medicineDao.getDic_Num(tableCoding, patientId);
        Medicine medicine = medicineDao.getMedicine(tableCoding);
        medicineDao.delDic_Num(dicNum.getId());
        return warnService.delNumber(medicine,number,user);
    }


    //实现药品库存回滚
    @Override
    public int rollBack(int pId) {
        int i = 0;
        List<DicNum> dicNum = medicineDao.getDic_Num(pId);
        int oId = medicineDao.getMId(pId);
        medicineDao.delMedicineByTableCoding(0,oId);
        for (DicNum dicNum1:dicNum){
            Medicine medicine = medicineDao.getMedicine(dicNum1.getTableCoding());
            medicine.setNumber(medicine.getNumber()+dicNum1.getNumber());
            medicineDao.updateMedicineNumber(medicine);
            medicineDao.delMedicineByTableCoding(dicNum1.getTableCoding(),oId);
            i = medicineDao.delDic_Num(dicNum1.getId());
        }
        return i;
    }

}
