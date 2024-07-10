package com.servlet;

import com.pojo.*;
import com.service.CuringService;
import com.service.Impl.CurdingServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.logDao;
import static com.util.Vessel.menuService;

@WebServlet("/curing")
public class CuringServlet extends BaseServlet {

    CuringService curingService = new CurdingServiceImpl();
    @Override
    public Class getServlet() {
        return CuringServlet.class;
    }

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session1.setAttribute("menuList", menuList);
        return "medicine/medicineManage/curingMedicine/curingList";
    }

    public LayuiTable<Curing> getAllCuring(HttpServletRequest request,HttpServletResponse response){
        List<Curing> curing = curingService.getCuring();
        LayuiTable<Curing> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(curing.size());
        layuiTable.setData(curing);
        return layuiTable;
    }

    public LayuiTable<Curing> getCuringByTab(HttpServletRequest request,HttpServletResponse response){
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        List<Curing> curing = curingService.getCuringByTab(tableCoding);
        LayuiTable<Curing> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(curing.size());
        layuiTable.setData(curing);
        return layuiTable;
    }

    public LayuiTable<Curing> getCuringByMId(HttpServletRequest request,HttpServletResponse response){
        int mId = Integer.parseInt(request.getParameter("mId"));
        List<Curing> curing = curingService.getCuringByMId(mId);
        LayuiTable<Curing> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(curing.size());
        layuiTable.setData(curing);
        return layuiTable;
    }

    public ResultData<Curing> updataCuring(HttpServletRequest request, HttpServletResponse response){
        Curing curing = new Curing();
        curing.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        curing.setmId(Integer.parseInt(request.getParameter("mId")));
        curing.setContent(request.getParameter("content"));
        curing.setId(Integer.parseInt(request.getParameter("id")));
        int i = curingService.updataCuring(curing);
        return Result.resultStatus(i);
    }

    public ResultData<Curing> addCuring(HttpServletRequest request, HttpServletResponse response){
        Curing curing = new Curing();
        curing.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        curing.setmId(Integer.parseInt(request.getParameter("mId")));
        curing.setContent(request.getParameter("content"));
        int i = curingService.addCuring(curing);
        return Result.resultStatus(i);
    }

    public ResultData<Curing> delCuring(HttpServletRequest request, HttpServletResponse response){
        int i1 = Integer.parseInt(request.getParameter("id"));
        int i = curingService.delCuring(i1);
        return Result.resultStatus(i);
    }
}
