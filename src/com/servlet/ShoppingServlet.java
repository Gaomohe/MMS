package com.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.Medicine;
import com.pojo.Menu;
import com.pojo.Sub_Apply;
import com.pojo.User;
import com.service.Impl.ShoppingServiceImpl;
import com.util.BaseServlet;
import com.util.GetTime;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

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
    public ResultData<Medicine> selectById(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        return shoppingService.selectById(StringDeal.toArray(dataString));
    }

    public ResultData add(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = null;
        String arrKu = request.getParameter("arrKu");
        String arrID = request.getParameter("arrID");
        int[] intID = StringDeal.toArray(arrID);
        int[] intKU = StringDeal.toArray(arrKu);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        for (int i = 0; i < intID.length; i++) {
            System.out.println("用户id"+user.getId()+"时间"+GetTime.getTime());
            Sub_Apply sub_apply = new Sub_Apply();
            sub_apply.setMid(intID[i]);
            sub_apply.setApplynum(intKU[i]);
            sub_apply.setApplyuserid(user.getId());
            sub_apply.setApplytime(GetTime.getTime());
            resultData = shoppingService.addSub_Apply(sub_apply);
        }
        return resultData;

    }
}
