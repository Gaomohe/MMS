package com.servlet;

import com.pojo.Menu;
import com.pojo.StockInForm;
import com.pojo.StockOutForm;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/StockOutForm")
public class StockOutFormServlet extends BaseServlet {

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/warehouseManage/stockOutForm/stockOutFormList";
    }

    //获取所有出库单（分页显示）
    public void selectStockOutForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockOutFormService.selectStockOutForm(page,limit));
    }
    public ResultData addStockOutForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockOutForm stockOutForm = new StockOutForm();
        stockOutForm.setOutStatus(request.getParameter("outStatus"));
        stockOutForm.setoDate(request.getParameter("oDate"));
        stockOutForm.setoManufactor(request.getParameter("oManufactor"));
        stockOutForm.setoType(request.getParameter("oType"));
        stockOutForm.setoNum(Integer.parseInt(request.getParameter("oNum")));
        stockOutForm.setoSalePrice(Integer.parseInt(request.getParameter("oSalePrice")));
        stockOutForm.setoAmount(Integer.parseInt(request.getParameter("oAmount")));
        stockOutForm.setoCost(Integer.parseInt(request.getParameter("oCost")));
        stockOutForm.setOperator(request.getParameter("operator"));
        stockOutForm.setAuditor(request.getParameter("auditor"));
        stockOutForm.setAuditTime(request.getParameter("auditTime"));
        stockOutForm.setDepartment(request.getParameter("department"));
        int i = stockOutFormService.addDoStockOutForm(stockOutForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(stockOutForm);
        }
        return resultData;
    }

    public ResultData delStockOutForm(HttpServletRequest request, HttpServletResponse response){
        int outId = Integer.parseInt(request.getParameter("outId"));
        ResultData resultData = new ResultData();
        int i = stockOutFormService.delStockOutFormById(outId);
        StockOutForm stockOutForm = new StockOutForm();
        stockOutForm.setOutId(outId);
        if (i>0){
            resultData.setMsg("删除成功");
            resultData.setStatus(200);
            resultData.setData(stockOutForm);
        }
        return resultData;
    }

    public ResultData selectStockOutFormById(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        int outId =Integer.parseInt(request.getParameter("outId"));
        StockOutForm stockOutForm = stockOutFormService.getStockOutFormById(outId);
        if (outId>0){
            resultData.setStatus(200);
            resultData.setMsg("");
            resultData.setData(stockOutForm);
        }
        return resultData;
    }

    public ResultData updateStockOutForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockOutForm stockOutForm = new StockOutForm();
        stockOutForm.setOutId(Integer.parseInt(request.getParameter("outId")));
        stockOutForm.setOutStatus(request.getParameter("outStatus"));
        stockOutForm.setoDate(request.getParameter("oDate"));
        stockOutForm.setoManufactor(request.getParameter("oManufactor"));
        stockOutForm.setoType(request.getParameter("oType"));
        stockOutForm.setoNum(Integer.parseInt(request.getParameter("oNum")));
        stockOutForm.setoSalePrice(Integer.parseInt(request.getParameter("oSalePrice")));
        stockOutForm.setoAmount(Integer.parseInt(request.getParameter("oAmount")));
        stockOutForm.setoCost(Integer.parseInt(request.getParameter("oCost")));
        stockOutForm.setOperator(request.getParameter("operator"));
        stockOutForm.setAuditor(request.getParameter("auditor"));
        stockOutForm.setAuditTime(request.getParameter("auditTime"));
        stockOutForm.setDepartment(request.getParameter("department"));
        int i = stockOutFormService.updateDoStockOutForm(stockOutForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("修改成功");
            resultData.setData(stockOutForm);
        }
        return resultData;
    }
    @Override
    public Class getServlet() {
        return StockOutFormServlet.class;
    }
}
