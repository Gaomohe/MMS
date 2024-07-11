package com.servlet;

import com.dao.PurchaseDao;
import com.pojo.Apply;
import com.pojo.User;
import com.service.Impl.PurchaseServiceImpl;
import com.service.PurchaseService;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,purchaseService.getAppointList(page,limit));
    }


}
