package com.servlet;

import com.dao.PurchaseDao;
import com.pojo.Apply;
import com.service.Impl.PurchaseServiceImpl;
import com.service.PurchaseService;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.util.Vessel.appointService;

@WebServlet("/purchase")
public class PurchaseServlet extends BaseServlet {
    PurchaseService purchaseService = new PurchaseServiceImpl();
    @Override
    public Class getServlet() {
        return PurchaseServlet.class;
    }

    public void getAllAppoint(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,purchaseService.getAppointList(page,limit));
    }


}
