package com.servlet;

import com.pojo.Menu;
import com.pojo.StockAllForm;
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
@WebServlet("/StockAllForm")
public class StockAllFormServlet extends BaseServlet {

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/warehouseManage/stockAllForm/stockAllFormList";
    }
    public void selectStockAllForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockAllService.selectStockAllForm(page,limit));
    }
    public ResultData addStockAllForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockAllForm stockAllForm = new StockAllForm();
        stockAllForm.setmName(request.getParameter("mName"));
        stockAllForm.setSpecification(request.getParameter("specification"));
        stockAllForm.setManufactor(request.getParameter("manufactor"));
        stockAllForm.setUnit(request.getParameter("unit"));
        stockAllForm.setDepartment(request.getParameter("department"));
        stockAllForm.setPosition(request.getParameter("position"));
        stockAllForm.setNumber(Integer.parseInt(request.getParameter("number")));
        stockAllForm.setBatchNumber(request.getParameter("batchNumber"));
        stockAllForm.setUsefulLife(request.getParameter("usefulLife"));
        stockAllForm.setPurchasePrice(Double.parseDouble(request.getParameter("purchasePrice")));
        stockAllForm.setSalePrice(Double.parseDouble(request.getParameter("")));
        stockAllForm.setProductDate(request.getParameter("productDate"));
        stockAllForm.setProfits(request.getParameter("profits"));
        stockAllForm.setCode(request.getParameter("code"));
        stockAllForm.setGoodsType(request.getParameter("goodsType"));
        stockAllForm.setmType(request.getParameter("mType"));
        stockAllForm.setDefined(request.getParameter("defined"));
        stockAllForm.setSupplier(request.getParameter("supplier"));
        stockAllForm.setWarehousingDate(request.getParameter("warehousingDate"));
        stockAllForm.setLocationDescription(request.getParameter("locationDescription"));
        stockAllForm.setSign(request.getParameter("sign"));
        stockAllForm.setWarehousingRemarks(request.getParameter("warehousingRemarks"));
        stockAllForm.setDrugFrom(request.getParameter("drugFrom"));
        stockAllForm.setHandlingInformation(request.getParameter("handlingInformation"));
        stockAllForm.setApprovalNumber(request.getParameter("approvalNumber"));
        stockAllForm.setLastCuringDate(request.getParameter("lastCuringDate"));
        stockAllForm.setTimesStorage(Integer.parseInt(request.getParameter("timesStorage")));
        stockAllForm.setDocumentNumber(request.getParameter("documentNumber"));
        stockAllForm.setPlaceOrigin(request.getParameter("placeOrigin"));
        stockAllForm.setBatchsNumber(request.getParameter("batchsNumber"));
        stockAllForm.setRecordNumber(Integer.parseInt(request.getParameter("recordNumber")));
        int i = stockAllService.addDoStockAllForm(stockAllForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(stockAllForm);
        }
        return resultData;
    }

    public ResultData delStockAllForm(HttpServletRequest request, HttpServletResponse response){
        int mId = Integer.parseInt(request.getParameter("mId"));
        ResultData resultData = new ResultData();
        int i = stockAllService.delStockAllFormById(mId);
        StockAllForm stockAllForm = new StockAllForm();
        stockAllForm.setmId(mId);
        if (i>0){
            resultData.setMsg("删除成功");
            resultData.setStatus(200);
            resultData.setData(stockAllForm);
        }
        return resultData;
    }

    public ResultData selectStockAllFormById(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        int mId =Integer.parseInt(request.getParameter("mId"));
        StockAllForm stockAllForm = stockAllService.getStockAllFormById(mId);
        if (mId>0){
            resultData.setStatus(200);
            resultData.setMsg("");
            resultData.setData(stockAllForm);
        }
        return resultData;
    }

    public ResultData updateStockAllForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockAllForm stockAllForm = new StockAllForm();
        stockAllForm.setmId(request.getIntHeader("mId"));
        stockAllForm.setmName(request.getParameter("mName"));
        stockAllForm.setSpecification(request.getParameter("specification"));
        stockAllForm.setManufactor(request.getParameter("manufactor"));
        stockAllForm.setUnit(request.getParameter("unit"));
        stockAllForm.setDepartment(request.getParameter("department"));
        stockAllForm.setPosition(request.getParameter("position"));
        stockAllForm.setNumber(Integer.parseInt(request.getParameter("number")));
        stockAllForm.setBatchNumber(request.getParameter("batchNumber"));
        stockAllForm.setUsefulLife(request.getParameter("usefulLife"));
        stockAllForm.setPurchasePrice(Double.parseDouble(request.getParameter("purchasePrice")));
        stockAllForm.setSalePrice(Double.parseDouble(request.getParameter("salePrice")));
        stockAllForm.setProductDate(request.getParameter("productDate"));
        stockAllForm.setProfits(request.getParameter("profits"));
        stockAllForm.setCode(request.getParameter("code"));
        stockAllForm.setGoodsType(request.getParameter("goodsType"));
        stockAllForm.setmType(request.getParameter("mType"));
        stockAllForm.setDefined(request.getParameter("defined"));
        stockAllForm.setSupplier(request.getParameter("supplier"));
        stockAllForm.setWarehousingDate(request.getParameter("warehousingDate"));
        stockAllForm.setLocationDescription(request.getParameter("locationDescription"));
        stockAllForm.setSign(request.getParameter("sign"));
        stockAllForm.setWarehousingRemarks(request.getParameter("warehousingRemarks"));
        stockAllForm.setDrugFrom(request.getParameter("drugFrom"));
        stockAllForm.setHandlingInformation(request.getParameter("handlingInformation"));
        stockAllForm.setApprovalNumber(request.getParameter("approvalNumber"));
        stockAllForm.setLastCuringDate(request.getParameter("lastCuringDate"));
        stockAllForm.setTimesStorage(Integer.parseInt(request.getParameter("timesStorage")));
        stockAllForm.setDocumentNumber(request.getParameter("documentNumber"));
        stockAllForm.setPlaceOrigin(request.getParameter("placeOrigin"));
        stockAllForm.setBatchsNumber(request.getParameter("batchsNumber"));
        stockAllForm.setRecordNumber(Integer.parseInt(request.getParameter("recordNumber")));
        int i = stockAllService.updateDoStockAllForm(stockAllForm);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("修改成功");
            resultData.setData(stockAllForm);
        }
        return resultData;
    }
    @Override
    public Class getServlet() {
        return StockAllFormServlet.class;
    }
}
