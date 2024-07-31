package com.service.Impl;

import com.dao.PatientDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.Pharmacy;
import com.pojo.User;
import com.service.PharmacyService;
import com.util.BaseDao;
import com.util.LayuiTable;
import org.apache.ibatis.session.SqlSession;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.pharmacyDao;
import static com.util.Vessel.pharmacyService;

public class PharmacyServiceImpl implements PharmacyService {
    //获取所有处方列表
    @Override
    public LayuiTable<Pharmacy> getPharmacyList(int page, int limit) {
        List<Pharmacy> pharmacyList = pharmacyDao.getPharmacyList(page,limit);
        int count = 0;
        for (Pharmacy pharmacy : pharmacyList) {
            boolean isPharmacy = pharmacyDao.isPharmacy(pharmacy);
            if (isPharmacy) {
                pharmacy.setIsPharmacy("是");
            }else {
                pharmacy.setIsPharmacy("否");
            }
            count++;
        }
        LayuiTable<Pharmacy> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setData(pharmacyList);
        layuiTable.setCount(count);

        return layuiTable;
    }

    //获取处方对应患者id
    @Override
    public int getpId(int phId) {
        return pharmacyDao.getpId(phId);
    }

    //获取处方中的具体药品
    @Override
    public LayuiTable<Medicine> checkPharmacy(int phId, int page, int limit) {
        List<Medicine> medicineList = pharmacyDao.checkPharmacy(phId,page,limit);
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setData(medicineList);
        layuiTable.setCount(medicineList.size());
        return layuiTable;
    }

    //患者取药
    @Override
    public int getMedicine(int mId, int pId, int phId) {
        int i = pharmacyDao.getMedicine(mId,pId);
        int j = pharmacyDao.getMedicine1(mId,phId);
        return i + j;
    }

    //单框查询
    @Override
    /*public LayuiTable<Pharmacy> selectPatient(Map<String, Object> searchCriteria) {
        // 提取并移除分页参数
        Integer pageNum = (Integer) searchCriteria.get("page");
        Integer pageSize = (Integer) searchCriteria.get("limit");
        int page = pageNum;
        int limit = pageSize;

        // 提取搜索参数并转换为字符串
        Object searchObj = searchCriteria.get("search");
        String searchTerm = searchObj != null ? searchObj.toString() : null;

        // 判断搜索参数是否为整数
        boolean isNumeric = searchTerm != null && searchTerm.matches("\\d+");

        // 将搜索参数相关的标志添加到 searchCriteria 中
        searchCriteria.put("isNumeric", isNumeric);
        searchCriteria.put("searchTerm", searchTerm);

        // 删除非 "searchTerm" 和 "isNumeric" 的参数
        Iterator<Map.Entry<String, Object>> iterator = searchCriteria.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            if (!"searchTerm".equals(entry.getKey()) && !"isNumeric".equals(entry.getKey())) {
                iterator.remove();
            }
        }

        SqlSession session = BaseDao.getSqlSession();
        PageHelper.startPage(page, limit);
        List<Pharmacy> list = session.getMapper(PatientDao.class).getPharmacy(searchCriteria);
        LayuiTable<Pharmacy> layuiTable = new LayuiTable<>();
        layuiTable.setCode(200);
        layuiTable.setMsg("success");
        layuiTable.setCount(list.size());
        layuiTable.setData(list);
        session.commit(); // 提交事务
        session.close(); // 关闭会话
        return layuiTable;
    }*/

    public LayuiTable<Pharmacy> selectPatient(Map<String, Object> searchCriteria) {
        // 提取并移除分页参数
        Integer pageNum = (Integer) searchCriteria.get("page");
        Integer pageSize = (Integer) searchCriteria.get("limit");
        int page = pageNum != null ? pageNum : 1; // 默认页码为1
        int limit = pageSize != null ? pageSize : 10; // 默认每页记录数为10

        // 提取搜索参数并转换为字符串
        Object searchObj = searchCriteria.get("search");
        String searchTerm = searchObj != null ? searchObj.toString() : null;

        // 判断搜索参数是否为整数
        boolean isNumeric = searchTerm != null && searchTerm.matches("\\d+");

        // 将搜索参数相关的标志添加到 searchCriteria 中
        searchCriteria.put("isNumeric", isNumeric);
        searchCriteria.put("searchTerm", searchTerm);

        // 删除非 "searchTerm" 和 "isNumeric" 的参数
        searchCriteria.keySet().removeIf(key -> !key.equals("searchTerm") && !key.equals("isNumeric"));

        SqlSession session = BaseDao.getSqlSession();
        PageHelper.startPage(page, limit);
        List<Pharmacy> list = session.getMapper(PatientDao.class).getPharmacy(searchCriteria);

        for (Pharmacy pharmacy : list) {
            boolean isPharmacy = pharmacyDao.isPharmacy(pharmacy);
            if (isPharmacy) {
                pharmacy.setIsPharmacy("是");
            }else {
                pharmacy.setIsPharmacy("否");
            }
        }

        PageInfo<Pharmacy> pageInfo = new PageInfo<>(list); // 获取分页信息

        LayuiTable<Pharmacy> layuiTable = new LayuiTable<>();
        layuiTable.setCode(200);
        layuiTable.setMsg("success");
        layuiTable.setCount((int) pageInfo.getTotal()); // 设置总记录数
        layuiTable.setData(pageInfo.getList()); // 获取当前页的数据
        session.commit(); // 提交事务
        session.close(); // 关闭会话
        return layuiTable;
    }

}
