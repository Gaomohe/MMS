package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.MedicineDao;
import com.pojo.Medicine;
import com.service.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    MedicineDao medicineDao = new MedicineDaoImpl();
    @Override
    public int addMedicine(Medicine medicine) {
        return 0;
    }

    @Override
    public int delMedicine(int tableCoding) {
        return 0;
    }

    @Override
    public int delMedicineByMId(int mId) {
        return 0;
    }

    @Override
    public int updateMedicinePrice(Medicine medicine) {
        return 0;
    }

    @Override
    public int updateMedicineLastCuringDate(Medicine medicine) {
        return 0;
    }

    @Override
    public int updateMedicineWarehousingDate(Medicine medicine) {
        return 0;
    }

    @Override
    public int updateMedicineNumber(Medicine medicine) {
        return 0;
    }

    @Override
    public int updateMedicineBasic(Medicine medicine) {
        return 0;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        return null;
    }

    @Override
    public Medicine getMedicine(int tableCoding) {
        return null;
    }

    @Override
    public List<Medicine> getMedicineByQuery(String[] query) {
        return null;
    }
}
