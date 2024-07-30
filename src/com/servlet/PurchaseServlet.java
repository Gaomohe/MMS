package com.servlet;

import com.dao.PurchaseDao;
import com.pojo.Apply;
import com.pojo.User;
import com.service.Impl.PurchaseServiceImpl;
import com.service.PurchaseService;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Arrays;

import static com.util.Vessel.*;

@WebServlet("/purchase")
public class PurchaseServlet extends BaseServlet {
    PurchaseService purchaseService = new PurchaseServiceImpl();
    @Override
    public Class getServlet() {
        return PurchaseServlet.class;
    }

    public void getAllAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购审批","获取所有申请信息");
        User user1 = (User)session9.getAttribute("user");
        user1.setUserName(name9);
        session9.setAttribute("user",user1);
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,purchaseService.getAppointList(page,limit));
    }

    public void getId(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("oId"));
        ToJSON.toJson(response,purchaseService.getId(id));
    }

    //审批通过
    public ResultData<Integer> isOk(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        int[] ints = StringDeal.toArray(dataString);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        user1.setUserName(name);
        session.setAttribute("user",user1);
        logService.setLog(name,"点击","财务审批","财务审核通过");
        return purchaseService.isok(ints,name);
    }
    public ResultData<Integer> noPass(HttpServletRequest request, HttpServletResponse response){
        String values = request.getParameter("values");
        String dataString = request.getParameter("dataString");
        int[] ints = StringDeal.toArray(dataString);
        return purchaseService.noPass(ints,values);
    }


}
