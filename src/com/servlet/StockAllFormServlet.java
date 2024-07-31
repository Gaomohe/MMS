package com.servlet;

import com.pojo.*;
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
@WebServlet("/StockAllForm")
public class StockAllFormServlet extends BaseServlet {

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","库存盘点","获取所有按钮");
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
        return "/medicine/warehouseManage/stockAllForm/stockAllFormList";
    }
    public void selectStockAllForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockAllService.selectStockAllForm(page,limit));
    }
    //复选框选择不同药品属性进行查询
    public void getStockAllFormByQuery(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","库存管理","多条件查询库存药品（非多轮）");
        String select1 = request.getParameter("select1");
        String select2 = request.getParameter("select2");
        String select3 = request.getParameter("select3");
        String select4 = request.getParameter("select4");
        String[] queries = {select1,select2,select3,select4};
        List<StockAllForm> stockInFormByQuery = stockAllService.getStockAllFormByQuery(queries);
        LayuiTable<StockAllForm> layuiTable = new LayuiTable<StockAllForm>();
        layuiTable.setData(stockInFormByQuery);
        ToJSON.toJson(response,layuiTable);
    }
    //输入药品名查询
    public void getStockAllFormByDrugName(HttpServletRequest request, HttpServletResponse response){
        String mName = request.getParameter("mName");
        String[] queries = {mName};
        List<StockAllForm> stockAllFormByDrugName = stockAllService.getStockAllFormByDrugName(queries);
        LayuiTable<StockAllForm> layuiTable = new LayuiTable<StockAllForm>();//因为表格是以layuiTable的形式展示的
        layuiTable.setData(stockAllFormByDrugName);
        ToJSON.toJson(response,layuiTable);
    }
    //获得药品名称，数量，用饼图展示
    public ResultData<List<StockAllForm>> getStockAllFormByEcharts(HttpServletRequest request, HttpServletResponse response){
        return stockAllService.getStockAllFormEChart();
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
        stockAllForm.setSalePrice(Double.parseDouble(request.getParameter("salePrice")));
        stockAllForm.setProductDate(request.getParameter("productDate"));
        stockAllForm.setProfits(request.getParameter("profits"));
        stockAllForm.setCode(request.getParameter("code"));
        stockAllForm.setGoodsType(request.getParameter("goodsType"));//商品分类
        stockAllForm.setmType(request.getParameter("mType"));//药品分类
        stockAllForm.setDefined(request.getParameter("defined"));//自定义类
        stockAllForm.setSupplier(request.getParameter("supplier"));
        stockAllForm.setWarehousingDate(request.getParameter("warehousingDate"));
        stockAllForm.setLocationDescription(request.getParameter("locationDescription"));
        stockAllForm.setSign(request.getParameter("sign"));
        stockAllForm.setWarehousingRemarks(request.getParameter("warehousingRemarks"));
        stockAllForm.setDrugFrom(request.getParameter("drugFrom"));//剂型
//        stockAllForm.setHandingInformation(request.getParameter("handlingInformation"));
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
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        ResultData resultData = new ResultData();
        int i = stockAllService.delStockAllFormById(tableCoding);
        StockAllForm stockAllForm = new StockAllForm();
        stockAllForm.setmId(tableCoding);
        if (i>0){
            resultData.setMsg("删除成功");
            resultData.setStatus(200);
            resultData.setData(stockAllForm);
        }
        return resultData;
    }

    public ResultData selectStockAllFormById(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        int tableCoding =Integer.parseInt(request.getParameter("tableCoding"));
        StockAllForm stockAllForm = stockAllService.getStockAllFormById(tableCoding);
        if (tableCoding>0){
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
//        stockAllForm.setHandingInformation(request.getParameter("handlingInformation"));
        stockAllForm.setApprovalNumber(request.getParameter("approvalNumber"));
        stockAllForm.setLastCuringDate(request.getParameter("lastCuringDate"));
        stockAllForm.setTimesStorage(Integer.parseInt(request.getParameter("timesStorage")));
        stockAllForm.setDocumentNumber(request.getParameter("documentNumber"));
        stockAllForm.setPlaceOrigin(request.getParameter("placeOrigin"));
        stockAllForm.setBatchsNumber(request.getParameter("batchsNumber"));
        stockAllForm.setRecordNumber(Integer.parseInt(request.getParameter("recordNumber")));
        stockAllForm.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
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
