package com.servlet;

import com.pojo.*;
import com.service.ApplyFaileService;
import com.service.Impl.ApplyFailedServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
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
    //获取正常出库出库单
    public void getNormalStockOut(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockOutFormService.getNormalStockOut(page,limit));
    }
    //获取质量不合格出库单
    public void getApplyFailedStockOut(HttpServletRequest request, HttpServletResponse response){
        ApplyFaileService applyFaileService = new ApplyFailedServiceImpl();
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<ApplyFailed> all = applyFaileService.getAll(page, limit);
        LayuiTable<ApplyFailed> layuiTable = new LayuiTable<ApplyFailed>();
        layuiTable.setData(all);
        ToJSON.toJson(response,layuiTable);
    }
    //根据出库单号，药品信息，出库时间查询出库信息
    public void getStockOutFormByQuery(HttpServletRequest request, HttpServletResponse response){
        String outNum = request.getParameter("outNum");
        String oName = request.getParameter("oName");
        String stockOutTime = request.getParameter("stockOutTime");
        String[] queries = {outNum,oName,stockOutTime};
        List<StockOutForm> stockOutFormByQuery = stockOutFormService.getStockOutFormByQuery(queries);
        LayuiTable<StockOutForm> layuiTable = new LayuiTable<StockOutForm>();
        layuiTable.setData(stockOutFormByQuery);
        ToJSON.toJson(response,layuiTable);
    }
//    public ResultData addStockOutForm(HttpServletRequest request, HttpServletResponse response){
//        ResultData resultData = new ResultData();
//        StockOutForm stockOutForm = new StockOutForm();
//        stockOutForm.setOutStatus(request.getParameter("outStatus"));
//        stockOutForm.setoDate(request.getParameter("oDate"));
//        stockOutForm.setoManufactor(request.getParameter("oManufactor"));
//        stockOutForm.setoType(request.getParameter("oType"));
//        stockOutForm.setoNum(Integer.parseInt(request.getParameter("oNum")));
//        stockOutForm.setoSalePrice(Integer.parseInt(request.getParameter("oSalePrice")));
//        stockOutForm.setoAmount(Integer.parseInt(request.getParameter("oAmount")));
//        stockOutForm.setoCost(Integer.parseInt(request.getParameter("oCost")));
//        stockOutForm.setOperator(request.getParameter("operator"));
//        stockOutForm.setAuditor(request.getParameter("auditor"));
//        stockOutForm.setAuditTime(request.getParameter("auditTime"));
//        stockOutForm.setDepartment(request.getParameter("department"));
//        int i = stockOutFormService.addDoStockOutForm(stockOutForm);
//        if (i>0){
//            resultData.setStatus(200);
//            resultData.setMsg("添加成功");
//            resultData.setData(stockOutForm);
//        }
//        return resultData;
//    }

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

//    public ResultData selectStockOutFormById(HttpServletRequest request, HttpServletResponse response){
//        ResultData resultData = new ResultData();
//        int outId =Integer.parseInt(request.getParameter("outId"));
//        StockOutForm stockOutForm = stockOutFormService.getStockOutFormById(outId);
//        if (outId>0){
//            resultData.setStatus(200);
//            resultData.setMsg("");
//            resultData.setData(stockOutForm);
//        }
//        return resultData;
//    }

    public ResultData updateStockOutForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockOutForm stockOutForm = new StockOutForm();
        stockOutForm.setOutId(Integer.parseInt(request.getParameter("outId")));
        stockOutForm.setOutNum(request.getParameter("outNum"));
        stockOutForm.setoName(request.getParameter("oName"));
        stockOutForm.setStandard(request.getParameter("standard"));
        stockOutForm.setManufactor(request.getParameter("manufactor"));
        stockOutForm.setUnit(request.getParameter("unit"));
        stockOutForm.setoNum(Integer.parseInt(request.getParameter("oNum")));
        stockOutForm.setCost(Integer.parseInt(request.getParameter("cost")));
        stockOutForm.setSalePrice(Integer.parseInt(request.getParameter("salePrice")));
        stockOutForm.setBatchNumber(request.getParameter("batchNumber"));
        stockOutForm.setProductDate(request.getParameter("productDate"));
        stockOutForm.setExpiration(request.getParameter("expiration"));
        stockOutForm.setStockOutTime(request.getParameter("stockOutTime"));
        stockOutForm.setDepartment(request.getParameter("department"));
        stockOutForm.setNotes(request.getParameter("notes"));
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
