package com.servlet;

import com.pojo.*;
import com.service.Impl.SalReturnServiceImpl;
import com.service.SalReturnService;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/returnSal")
public class SalReturnServlet extends BaseServlet {

    SalReturnService salReturnService = new SalReturnServiceImpl();
    @Override
    public Class getServlet() {
        return SalReturnServlet.class;
    }

    //获取按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","退货退款","获取所有按钮");
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "页面";
    }
    //获取所有回货单
    public LayuiTable<SalReturn> getQualityBySS(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        int allSalReturn1 = salReturnService.getAllSalReturn();
        LayuiTable<SalReturn> layuiTable = new LayuiTable<>();
        if (order==null){
            List<SalReturn> allSalReturn = salReturnService.getAllSalReturn(page, limit);
            layuiTable.setCode(0);
            layuiTable.setCount(allSalReturn1);
            layuiTable.setData(allSalReturn);
            layuiTable.setMsg("操作成功");
        }else {
            List<SalReturn> allSalReturn = salReturnService.getAllSalReturn(page, limit, order, sort);
            layuiTable.setCode(0);
            layuiTable.setCount(allSalReturn1);
            layuiTable.setData(allSalReturn);
            layuiTable.setMsg("操作成功");
        }
        return layuiTable;
    }

    //获取一个订单
    public ResultData<SalReturn> getSalReturnOne(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        SalReturn salReturnOne = salReturnService.getSalReturnOne(Integer.parseInt(id));
        return Result.resultData(salReturnOne);
    }

    //修改订单收货人
    public ResultData<SalReturn> updateConsignee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String consignee = request.getParameter("consignee");
        SalReturn salReturn = new SalReturn();
        salReturn.setId(Integer.parseInt(id));
        salReturn.setConsignee(consignee);
        int i = salReturnService.updateConsignee(salReturn);
        return Result.resultStatus(i);
    }
    //修改（在退单页面新加）
    public ResultData<SalReturn> updateAll(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String address = request.getParameter("address");
        String shippingWay = request.getParameter("shippingWay");
        String consigner = request.getParameter("id");
        SalReturn salReturn = new SalReturn();
        salReturn.setId(Integer.parseInt(id));
        int i = salReturnService.updateConsignee(salReturn);
        return Result.resultStatus(i);
    }
    //删除退货单
    public ResultData<SalReturn> delSalReturn(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        int i = salReturnService.delSalReturn(Integer.parseInt(id));
        return Result.resultStatus(i);
    }
}
