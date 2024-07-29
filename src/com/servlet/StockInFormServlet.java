package com.servlet;

import com.pojo.*;
import com.util.BaseServlet;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;
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

    //获取所有供货商
    public void getManufactorAll(HttpServletRequest request, HttpServletResponse response){
        List<Orders> stockInFormList = stockInFormService.getManufactorWithNoRepeat();
        ToJSON.toJson(response,stockInFormList);
    }
    //获取所有供应商对应的药品名并分页显示
    public void getAllStockForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response,stockInFormService.getAllStockForm(page,limit));
    }

    //通过供应商,药品名称和入库状态查询出入库单
    public void getStockInFormByManufactorAndDrugName(HttpServletRequest request, HttpServletResponse response){
        String manufactorName = request.getParameter("manufactorName");
        String rName = request.getParameter("rName");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response,stockInFormService.getStockInFormByManufactorOrDrugName(page,limit,manufactorName,rName));
    }


    //获取所有入库单（分页显示）
    public void selectStockInForm(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, stockInFormService.selectStockInForm(page,limit));
    }
    //添加入库单
    public ResultData addStockInForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockInWithQuality stockInWithQuality = new StockInWithQuality();
        stockInWithQuality.setStockInNum(request.getParameter("StockInNum"));
        stockInWithQuality.setManufactor(request.getParameter("manufactor"));
        stockInWithQuality.setrName(request.getParameter("rName"));
        stockInWithQuality.setStandard(request.getParameter("standard"));
        stockInWithQuality.setUnit(request.getParameter("unit"));
        stockInWithQuality.setCost(Integer.parseInt(request.getParameter("cost")));
        stockInWithQuality.setSalePrice(Integer.parseInt(request.getParameter("salePrice")));
        stockInWithQuality.setBatchNumber(request.getParameter("batchNumber"));
        stockInWithQuality.setProductDate(request.getParameter("productDate"));
        stockInWithQuality.setExpiration(request.getParameter("expiration"));
        stockInWithQuality.setStockInTime(GetTime.getTime());//直接在后端加入当前时间
        stockInWithQuality.setDepartment(request.getParameter("department"));
        stockInWithQuality.setTotlNumber(Integer.parseInt(request.getParameter("totlNumber")));
        stockInWithQuality.setStorageStatus("已入库");
        stockInWithQuality.setId(Integer.parseInt(request.getParameter("id")));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        int i = stockInFormService.addDoStockInForm(stockInWithQuality,name,user);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(stockInWithQuality);
        }
        return resultData;
    }
    //删除入库单
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
    //通过入库单id(注意不是入库单号)查询
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
    //根据入库单号，药品信息，入库时间查询入库信息
    public void getStockInFormByQuery(HttpServletRequest request, HttpServletResponse response){
        String stockInNum = request.getParameter("stockInNum");
        String rName = request.getParameter("rName");
        String stockInTime = request.getParameter("stockInTime");
        String[] queries = {stockInNum,rName,stockInTime};
        List<StockInForm> stockInFormByQuery = stockInFormService.getStockInFormByQuery(queries);
        LayuiTable<StockInForm> layuiTable = new LayuiTable<StockInForm>();//因为表格是以layuiTable的形式展示的
        layuiTable.setData(stockInFormByQuery);
        ToJSON.toJson(response,layuiTable);
    }
    //随机生成单据编号
    public ResultData<String> selectGeneratedStockInNumber(HttpServletRequest request, HttpServletResponse response){
        String string = StringDeal.generateStockInNumber("MMS");//调用随机生成入库单号的方法
        ResultData<String> resultData = new ResultData<String>();
        resultData.setData(string);
        return resultData;
    }

    //按条件查询(可单个查询)重新加载数据表格
    public void getStockInSupplierByQuery(HttpServletRequest request, HttpServletResponse response){
        String stockInNum = request.getParameter("stockInNum");
        String rName = request.getParameter("rName");
        String stockInTime = request.getParameter("stockInTime");
        String[] queries = {stockInNum,rName,stockInTime};
        List<StockInForm> stockInFormByQuery = stockInFormService.getStockInFormByQuery(queries);
        LayuiTable<StockInForm> layuiTable = new LayuiTable<StockInForm>();//因为表格是以layuiTable的形式展示的
        layuiTable.setData(stockInFormByQuery);
        ToJSON.toJson(response,layuiTable);
    }
    //更新入库单
    public ResultData updateStockInForm(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        StockInForm stockInForm = new StockInForm();
        stockInForm.setrId(Integer.parseInt(request.getParameter("rId")));
        stockInForm.setStockInNum(request.getParameter("stockInNum"));
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
