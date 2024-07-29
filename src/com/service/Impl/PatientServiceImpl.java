package com.service.Impl;

import com.dao.ApplyDao;
import com.dao.PatientDao;
import com.github.pagehelper.PageHelper;
import com.pojo.Apply;
import com.pojo.Patient;
import com.service.PatientService;
import com.util.BaseDao;
import com.util.GetTime;
import com.util.LayuiTable;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {

    //单框查询病患信息
    @Override
    public LayuiTable<Patient> selectPatient(Map<String, Object> searchCriteria) {
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
        List<Patient> list = session.getMapper(PatientDao.class).getPatients(searchCriteria);
        LayuiTable<Patient> layuiTable = new LayuiTable<>();
        layuiTable.setCode(200);
        layuiTable.setMsg("success");
        layuiTable.setCount(list.size());
        layuiTable.setData(list);
        session.commit(); // 提交事务
        session.close(); // 关闭会话
        return layuiTable;
    }



}
