package com.servlet;

import com.pojo.*;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;
@WebServlet("/StockInForm")
public class StockInFormServlet extends BaseServlet {

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/warehouseManage/stockInForm/stockInFormList";
    }
    //获取所有入库单（分页显示）
    public void selectStockInForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockInFormService.selectStockInForm(page,limit));
    }
    public ResultData addStockInForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockInForm stockInForm = new StockInForm();
        stockInForm.setrName(request.getParameter("rName"));
        stockInForm.setStandard(request.getParameter("standard"));
        stockInForm.setManufactor(request.getParameter("manufactor"));
        stockInForm.setUnit(request.getParameter("unit"));
        stockInForm.setrNum(Integer.parseInt(request.getParameter("rNum")));
        stockInForm.setCost(Integer.parseInt(request.getParameter("cost")));
        stockInForm.setSalePrice(Integer.parseInt(request.getParameter("salePrice")));
        stockInForm.setBatchNumber(request.getParameter("batchNumber"));
        stockInForm.setProductDate(request.getParameter("productDate"));
        stockInForm.setExpiration(request.getParameter("expiration"));
        stockInForm.setStockInTime(request.getParameter("stockInTime"));
        stockInForm.setDepartment(request.getParameter("department"));
        stockInForm.setNotes(request.getParameter("notes"));
        int i = stockInFormService.addDoStockInForm(stockInForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(stockInForm);
        }
        return resultData;
    }

    public ResultData delStockInForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("rId"));
        ResultData resultData = new ResultData();
        int i = stockInFormService.delStockInFormById(id);
        StockInForm stockInForm = new StockInForm();
        stockInForm.setrId(id);
        if (i>0){
            resultData.setMsg("删除成功");
            resultData.setStatus(200);
            resultData.setData(stockInForm);
        }
        return resultData;
    }

    public ResultData selectStockInFormById(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        int rId =Integer.parseInt(request.getParameter("rId"));
        StockInForm stockInForm = stockInFormService.getStockInFormById(rId);
        if (rId>0){
            resultData.setStatus(200);
            resultData.setMsg("");
            resultData.setData(stockInForm);
        }
        return resultData;
    }
    //多条件查询库存（非多轮）
    public void getStockInFormByQuery(HttpServletRequest request, HttpServletResponse response){
        String rId = request.getParameter("rId");
        String rName = request.getParameter("rName");
        String stockInTime = request.getParameter("stockInTime");
        String[] queries = {rId,rName,stockInTime};
        List<StockInForm> stockInFormByQuery = stockInFormService.getStockInFormByQuery(queries);
        LayuiTable<StockInForm> layuiTable = new LayuiTable<StockInForm>();//因为表格是以layuitable的形式展示的
        layuiTable.setData(stockInFormByQuery);
        ToJSON.toJson(response,layuiTable);
    }

    public ResultData updateStockInForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockInForm stockInForm = new StockInForm();
        stockInForm.setrId(Integer.parseInt(request.getParameter("rId")));
        stockInForm.setrName(request.getParameter("rName"));
        stockInForm.setStandard(request.getParameter("standard"));
        stockInForm.setManufactor(request.getParameter("manufactor"));
        stockInForm.setUnit(request.getParameter("unit"));
        stockInForm.setrNum(Integer.parseInt(request.getParameter("rNum")));
        stockInForm.setCost(Integer.parseInt(request.getParameter("cost")));
        stockInForm.setSalePrice(Integer.parseInt(request.getParameter("salePrice")));
        stockInForm.setBatchNumber(request.getParameter("batchNumber"));
        stockInForm.setProductDate(request.getParameter("productDate"));
        stockInForm.setExpiration(request.getParameter("expiration"));
        stockInForm.setStockInTime(request.getParameter("stockInTime"));
        stockInForm.setDepartment(request.getParameter("department"));
        stockInForm.setNotes(request.getParameter("notes"));
        int i = stockInFormService.updateDoStockInForm(stockInForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("修改成功");
            resultData.setData(stockInForm);
        }
        return resultData;
    }

    @Override
    public Class getServlet() {
        return StockInFormServlet.class;
    }
}
