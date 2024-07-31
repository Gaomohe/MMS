package com.servlet;


import com.pojo.*;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.*;

@WebServlet("/pharmacy")
public class PharmacyServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return PharmacyServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","药师审查取药");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/outpatientManager/pharmacy/pharmacyList";
    }

    //获取所有按钮
    public String getMenuBtn1(HttpServletRequest request, HttpServletResponse response){
        int phId = Integer.parseInt(request.getParameter("phId"));
        int resId = 306;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","审查处方详情");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        session.setAttribute("phId",phId);
        return "medicine/outpatientManager/pharmacy/checkPharmacy";
    }

    //获取处方表
    public void getPharmacyList(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","获取处方表");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page - 1) * limit;
        LayuiTable<Pharmacy> layuiTable = pharmacyService.getPharmacyList(page,limit);
        ToJSON.toJson(response,layuiTable);
    }

    //处方审核
    public void Check(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String phIdStr = request.getParameter("pIds");
        int phId = Integer.parseInt(phIdStr);
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","审查处方详情");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page - 1) * limit;
        LayuiTable<Medicine> layuiTable = pharmacyService.checkPharmacy(phId,page,limit);
        ToJSON.toJson(response,layuiTable);
    }

    //病患信息回显
    public void backValues(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        int phId = Integer.parseInt(request.getParameter("patientId"));
        int pId = pharmacyService.getpId(phId);
        Patient patient = outpatientService.backValues(pId);
        ToJSON.toJson(response,patient);
    }

    //患者取药
    public ResultData getMedicine(HttpServletRequest request, HttpServletResponse response){
        int mId = Integer.parseInt(request.getParameter("mId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int phId = (Integer)session.getAttribute("phId");
        int pId = pharmacyService.getpId(phId);
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"点击","门诊管理","患者取药--药师审查");
        int i = pharmacyService.getMedicine(mId,pId,phId);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }

    public void Search(HttpServletRequest request, HttpServletResponse response) {
        // 获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 存储解析后的搜索条件
        Map<String, Object> searchCriteria = new HashMap<>();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            if (values != null && values.length > 0) {
                String value = values[0];
                try {
                    // 尝试将值解析为整数
                    int intValue = Integer.parseInt(value);
                    searchCriteria.put(key, intValue);
                } catch (NumberFormatException e1) {
                    try {
                        // 尝试将值解析为双精度浮点数
                        double doubleValue = Double.parseDouble(value);
                        searchCriteria.put(key, doubleValue);
                    } catch (NumberFormatException e2) {
                        // 如果无法解析为整数或双精度浮点数，默认将值作为字符串处理
                        searchCriteria.put(key, value);
                    }
                }
            }
        }

        // 输出解析后的搜索条件
        LayuiTable<Pharmacy> layuiTable = pharmacyService.selectPatient(searchCriteria);
        ToJSON.toJson(response,layuiTable);
    }
}
