package com.servlet;

import com.pojo.Menu;
import com.pojo.Orders;
import com.pojo.Role;
import com.pojo.User;
import com.service.OrdersService;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.TableJSON;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.menuService;
import static com.util.Vessel.ordersService;

@WebServlet("/orders")
public class OrdersServlet extends BaseServlet {
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/shoppingManage/order/orderList";
    }
    //获取所有订单
    public void selectOrders(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, ordersService.selectOrders(page,limit));
    }
    @Override
    public Class getServlet() {
        return OrdersServlet.class;
    }
}
