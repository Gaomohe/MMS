package com.servlet;

import com.pojo.*;
import com.service.CuringService;
import com.service.Impl.CurdingServiceImpl;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.TypeServiceImpl;
import com.service.MedicineService;
import com.service.TypeService;
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

import static com.util.Vessel.*;
import static com.util.Vessel.logService;

@WebServlet("/curing")
public class CuringServlet extends BaseServlet {

    CuringService curingService = new CurdingServiceImpl();
    MedicineService medicineService = new MedicineServiceImpl();
    TypeService typeService= new TypeServiceImpl();
    @Override
    public Class getServlet() {
        return CuringServlet.class;
    }
    //获取养护页面的按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
        HttpSession session3 = request.getSession();
        HttpSession session4 = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        List<Type> allGoodsType = typeService.getAllGoodsType();
        List<Type> allMType = typeService.getAllMType();
        List<Type> allfreeType = typeService.getAllfreeType();
        List<Type> alldosage = typeService.getAlldosage();
        session.setAttribute("menuList",menuList);
        session1.setAttribute("type1",allGoodsType);
        session2.setAttribute("type2",allMType);
        session3.setAttribute("type3",allfreeType);
        session4.setAttribute("type4",alldosage);
        return "medicine/medicineManage/curingMedicine/curingList";
    }
    //获取养护页面信息（分页+状态）
    public LayuiTable<Medicine> getState(HttpServletRequest request,HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        int i = medicineService.getAllMedicine();
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        if (order==null){
            List<Medicine> state = curingService.getState(page,limit);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(state);
            layuiTable.setMsg("操作成功");
        }else {
            List<Medicine> state = curingService.getState(page,limit,order,sort);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(state);
            layuiTable.setMsg("操作成功");
        }
        return layuiTable;
    }

    //获取所有养护信息
    public LayuiTable<Curing> getAllCuring(HttpServletRequest request,HttpServletResponse response){
        List<Curing> curing = curingService.getCuring();
        LayuiTable<Curing> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(curing.size());
        layuiTable.setData(curing);
        return layuiTable;
    }

    //根据Time获取养护信息
    public LayuiTable<Medicine> getCuringByTime(HttpServletRequest request,HttpServletResponse response){
        String time = request.getParameter("time");
        List<Medicine> midicineByTime = curingService.getMidicineByTime(time);
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(midicineByTime.size());
        layuiTable.setData(midicineByTime);
        return layuiTable;
    }

    //根据name获取养护信息
    public LayuiTable<Medicine> getCuringByName(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        List<Medicine> midicineByTime = curingService.getMidicineByName(name);
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setCount(midicineByTime.size());
        layuiTable.setData(midicineByTime);
        return layuiTable;
    }
    //根据tableCoding获取养护信息
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

    //根据Mid获取养护信息
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

    //修改养护信息
    public ResultData<Curing> updataCuring(HttpServletRequest request, HttpServletResponse response){
        Curing curing = new Curing();
        curing.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        curing.setmId(Integer.parseInt(request.getParameter("mId")));
        curing.setContent(request.getParameter("content"));
        curing.setId(Integer.parseInt(request.getParameter("id")));
        int i = curingService.updataCuring(curing);
        return Result.resultStatus(i);
    }

    //批量修改养护信息
    public ResultData<Medicine> updateMedicineLastCuringDate(HttpServletRequest request, HttpServletResponse response){
        String tableCoding = request.getParameter("tableCoding");
        String[] arr = tableCoding.split(",");
        int i= 0;
        for (String s:arr){
            int i1 = Integer.parseInt(s);
            i = medicineService.updateMedicineLastCuringDate(i1);
        }
        return Result.resultStatus(i);
    }

    //添加养护信息
    public ResultData<Curing> addCuring(HttpServletRequest request, HttpServletResponse response){
        Curing curing = new Curing();
        curing.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        curing.setmId(Integer.parseInt(request.getParameter("mId")));
        curing.setContent(request.getParameter("content"));
        int i = curingService.addCuring(curing);
        return Result.resultStatus(i);
    }

    //删除养护信息
    public ResultData<Curing> delCuring(HttpServletRequest request, HttpServletResponse response){
        int i1 = Integer.parseInt(request.getParameter("id"));
        int i = curingService.delCuring(i1);
        return Result.resultStatus(i);
    }
}
