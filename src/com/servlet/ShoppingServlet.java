package com.servlet;

import com.dao.Impl.PurchaseDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.Medicine;
import com.pojo.Menu;
import com.pojo.Sub_Apply;
import com.pojo.User;
import com.service.Impl.ShoppingServiceImpl;
import com.util.BaseServlet;
import com.util.GetTime;
import com.util.Result;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.*;

@WebServlet("/shopping")
public class ShoppingServlet extends BaseServlet {
    ShoppingServiceImpl shoppingService = new ShoppingServiceImpl();
    PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();
    @Override
    public Class<?> getServlet() {
        return ShoppingServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","获取所有按钮");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), Integer.parseInt(request.getParameter("resId")));
        List<Medicine> kindList = shoppingService.getKind();
        List<Medicine> sup = shoppingService.getSup();
        session.setAttribute("menuList",menuList);
        session.setAttribute("kindList",kindList);
        session.setAttribute("sup",sup);
        session.setAttribute("name9",name9);

        return "/medicine/shoppingManage/requestApply/shopList";
    }

    //获取所有采购申请信息
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","获取所有采购申请信息");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page =(page-1)*limit;
        ToJSON.toJson(response,shoppingService.getAll(page,limit));
    }

    //获取所有药品规格
    public void getSelectedValue(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","获取所有药品规格");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page =(page-1)*limit;
        ToJSON.toJson(response,shoppingService.getSelectedValue(page,limit,request.getParameter("drugFrom")));
    }

    public void time(HttpServletRequest request, HttpServletResponse response){
        String value = request.getParameter("value").replace("-", "");
        ToJSON.toJson(response,shoppingService.getSelectedTime(value));
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","条件查询所有采购信息");
        String searchValue = request.getParameter("searchValue");
        ToJSON.toJson(response,shoppingService.likeSelect(searchValue));
    }
    public ResultData<Medicine> selectById(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","通过id获取所有采购申请");
        String dataString = request.getParameter("dataString");
        return shoppingService.selectById(StringDeal.toArray(dataString));
    }

    public ResultData add(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"添加","采购申请","新增采购申请信息");
        ResultData resultData = null;
        String arrKu = request.getParameter("arrKu");
        String arrID = request.getParameter("arrID");
        int[] intID = StringDeal.toArray(arrID);
        int[] intKU = StringDeal.toArray(arrKu);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        long nowTimes = StringDeal.getNowTimes();
        for (int i = 0; i < intID.length; i++) {
            System.out.println("用户id"+user.getId()+"时间"+GetTime.getTime());
            Sub_Apply sub_apply = new Sub_Apply();
            sub_apply.setMid(intID[i]);
            sub_apply.setApplynum(intKU[i]);
            sub_apply.setApplyuserid(user.getId());
            sub_apply.setApplytime(GetTime.getTime());
            sub_apply.setBatch_num(nowTimes);
            resultData = shoppingService.addSub_Apply(sub_apply);
        }

        //执行完毕，发送消息
        purchaseDao.isOK_msg(nowTimes,"申请信息","您的药品申请已经发出,请耐心等待审批结果!",1001,1001);


        return resultData;
    }

    public ResultData insertApply(HttpServletRequest request, HttpServletResponse response){
        int i = appointService.insertApply();
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }
    //处方药
    public void prescriptionDrug(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"添加","采购申请","添加药品计量描述");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,shoppingService.prescriptionDrug(page,limit));
    }
    public void getSelectedSup(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","采购申请","获取所有药品规格");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page =(page-1)*limit;
        ToJSON.toJson(response,shoppingService.getSelectedSup(page,limit,request.getParameter("drugFrom")));
    }
}
