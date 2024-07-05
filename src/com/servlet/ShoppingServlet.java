package com.servlet;

import com.pojo.Medicine;
import com.pojo.Menu;
import com.pojo.User;
import com.service.Impl.ShoppingServiceImpl;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.menuService;

@WebServlet("/shopping")
public class ShoppingServlet extends BaseServlet {
    ShoppingServiceImpl shoppingService = new ShoppingServiceImpl();

    @Override
    public Class<?> getServlet() {
        return ShoppingServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), Integer.parseInt(request.getParameter("resId")));
        List<Medicine> kindList = shoppingService.getKind();
        session.setAttribute("menuList",menuList);
        session.setAttribute("kindList",kindList);
        return "/medicine/shoppingManage/requestApply/shopList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,shoppingService.getAll(Integer.parseInt(request.getParameter("page")),Integer.parseInt(request.getParameter("limit"))));
    }
    public void getSelectedValue(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,shoppingService.getSelectedValue(request.getParameter("drugFrom")));
    }

    public void time(HttpServletRequest request, HttpServletResponse response){
        String value = request.getParameter("value").replace("-", "");
        ToJSON.toJson(response,shoppingService.getSelectedTime(value));
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String searchValue = request.getParameter("searchValue");
        ToJSON.toJson(response,shoppingService.likeSelect(searchValue));
    }
}
