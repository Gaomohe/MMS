package com.servlet;

import com.pojo.Menu;
import com.pojo.Price;
import com.pojo.Type;
import com.pojo.User;
import com.service.Impl.PriceServiceImpl;
import com.service.Impl.TypeServiceImpl;
import com.service.PriceService;
import com.service.TypeService;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Service;
import java.util.List;

import static com.util.Vessel.menuService;

@WebServlet("/price")
public class PriceServlet extends BaseServlet {

    PriceService priceService = new PriceServiceImpl();
    TypeService typeService = new TypeServiceImpl();
    @Override
    public Class getServlet() {
        return PriceServlet.class;
    }

    //历史价格界面获取按钮
    public String getMenuBtn2(HttpServletRequest request, HttpServletResponse response){
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
        return "medicine/medicineManage/medPrice/priceList";
    }

    //主要显示数据来源于药典的模块。
    //添加历史价格
    public ResultData<Price> addPrice(HttpServletRequest request, HttpServletResponse response){
        String salePrice = request.getParameter("salePrice");
        if (salePrice.equals(" ")){
            salePrice = "0.0";
        }
        Price price = new Price();
        price.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        price.setmId(Integer.parseInt(request.getParameter("mId")));
        price.setHistoryPrice(Double.parseDouble(salePrice));
        HttpSession session = request.getSession();
        session.setAttribute("price",price.getHistoryPrice());
        session.setAttribute("tableCoding",price.getTableCoding());
        int i = priceService.addHistory(price);
        return Result.resultStatus(i);
    }
    //获取所有历史价格（没用）
    public LayuiTable<Price> getPriceAll(HttpServletRequest request, HttpServletResponse response){
        List<Price> historyAll = priceService.getHistoryAll();
        LayuiTable<Price> layuiTable = new LayuiTable();
        layuiTable.setData(historyAll);
        return layuiTable;
    }
    //根据tableCoding获取历史价格
    public LayuiTable<Price> getPriceByTabCod(HttpServletRequest request, HttpServletResponse response){
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        List<Price> historyAll = priceService.getHistoryByTab(tableCoding);
        LayuiTable<Price> layuiTable = new LayuiTable();
        layuiTable.setData(historyAll);
        return layuiTable;
    }
    //根据mid获取历史价格
    public LayuiTable<Price> getPriceByMId(HttpServletRequest request, HttpServletResponse response){
        int mId = Integer.parseInt(request.getParameter("mId"));
        List<Price> historyAll = priceService.getHistoryByMid(mId);
        LayuiTable<Price> layuiTable = new LayuiTable();
        layuiTable.setData(historyAll);
        return layuiTable;
    }
    //根据时间获取历史价格（没用）
    public ResultData<Price> getPriceByTime(HttpServletRequest request, HttpServletResponse response){
        String time = request.getParameter("time");
        Price historyByTime = priceService.getHistoryByTime(time);
        ResultData<Price> priceResultData = new ResultData<>();
        priceResultData.setData(historyByTime);
        return priceResultData;
    }
    //删除历史价格
    public ResultData<Price> delPrice(HttpServletRequest request, HttpServletResponse response){
        int i1 = Integer.parseInt(request.getParameter("id"));
        int i = priceService.delHistoryById(i1);
        return Result.resultStatus(i);
    }

}
