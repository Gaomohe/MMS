package com.servlet;

import com.pojo.*;
import com.service.Impl.QualityServiceImpl;
import com.service.Impl.SalReturnServiceImpl;
import com.service.Impl.TypeServiceImpl;
import com.service.QualityService;
import com.service.SalReturnService;
import com.service.TypeService;
import com.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/quality")
public class QualityServlet extends BaseServlet {

    QualityService qualityService = new QualityServiceImpl();
    TypeService typeService = new TypeServiceImpl();
    SalReturnService salReturnService = new SalReturnServiceImpl();
    @Override
    public Class getServlet() {
        return QualityServlet.class;
    }

    //获取按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","获取所有按钮");
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
        HttpSession session3 = request.getSession();
        HttpSession session4 = request.getSession();
        HttpSession session5 = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        List<Type> allGoodsType = typeService.getAllGoodsType();
        List<Type> allMType = typeService.getAllMType();
        List<Type> allfreeType = typeService.getAllfreeType();
        List<Type> alldosage = typeService.getAlldosage();
        session.setAttribute("menuList",menuList);
        session5.setAttribute("menuList2",menuList);
        session1.setAttribute("type1",allGoodsType);
        session2.setAttribute("type2",allMType);
        session3.setAttribute("type3",allfreeType);
        session4.setAttribute("type4",alldosage);
        return "medicine/qualityManage/qualityTest/qualityList";
    }


    //根据入库信息获取所有质检信息(主要显示)
    public LayuiTable<Quality> getQualityBySS(HttpServletRequest request, HttpServletResponse response){
        String storageStatus = request.getParameter("storageStatus");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        List<Quality> qualityBySS = qualityService.getQualityBySS(storageStatus);
        LayuiTable<Quality> layuiTable = new LayuiTable<>();
        if (order==null){
            List<Quality> quality = qualityService.getQualityBySS(storageStatus,page,limit);
            layuiTable.setCode(0);
            layuiTable.setCount(qualityBySS.size());
            layuiTable.setData(quality);
            layuiTable.setMsg("操作成功");
        }else {
            List<Quality> quality = qualityService.getQualityBySS(storageStatus,page,limit,order,sort);
            layuiTable.setCode(0);
            layuiTable.setCount(qualityBySS.size());
            layuiTable.setData(quality);
            layuiTable.setMsg("操作成功");
        }
        return layuiTable;
    }

    //根据时间获取质检表
    public LayuiTable<Quality> getQualityByTime(HttpServletRequest request, HttpServletResponse response){
        String time = request.getParameter("time");
        String sql = request.getParameter("sql");
        if (sql.equals("1")){
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='未入库')AS a";
        }else {
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='已入库')AS a";
        }
        List<Quality> qualityByTime = qualityService.getQualityByTime(sql, time);
        LayuiTable<Quality> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setCount(qualityByTime.size());
        layuiTable.setData(qualityByTime);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }
    //根据药品名称获取质检表
    public LayuiTable<Quality> getQualityBymName(HttpServletRequest request, HttpServletResponse response){
        String mName = request.getParameter("mName");
        String sql = request.getParameter("sql");
        if (sql.equals("1")){
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='未入库')AS a";
        }else {
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='已入库')AS a";
        }
        List<Quality> qualityByTime = qualityService.getQualityByName(sql, mName);
        LayuiTable<Quality> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setCount(qualityByTime.size());
        layuiTable.setData(qualityByTime);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }

    //根据查询获取质检表
    public ResultData<Quality> getQualityByQuery(HttpServletRequest request, HttpServletResponse response){
        String select1 = request.getParameter("select1");
        String select2 = request.getParameter("select2");
        String select3 = request.getParameter("select3");
        String select4 = request.getParameter("select4");
        String sql = request.getParameter("sql");
        if (sql.equals("1")){
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='未入库')AS a";
        }else {
            sql="(SELECT * FROM `quality` WHERE `storageStatus`='已入库')AS a";
        }
        String[] queries = {select1,select2,select3,select4};
        List<Quality> quality = qualityService.getQualityByQuery(sql,queries);
        return Result.resultData(quality);
    }
    //根据id获取质检表
    public ResultData<Quality> getQualityById(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String sql = request.getParameter("sql");
        Quality quality = new Quality();
        quality.setId(Integer.parseInt(id));
        Quality qualityByID = qualityService.getQualityByID(quality);
        return Result.resultData(qualityByID);
    }

    //修改质检表质检状态
    public ResultData<Quality> updateQualityStatue(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","质量管理","药品质量检测");
        Quality quality = new Quality();
        quality.setId(id);
        quality.setWarehousingRemarks(name);
        int i = qualityService.updateQualityStatue(quality);
        int i1 = qualityService.updateQualityTime(quality);
        int i2 = 0;
        if (i+i1 == 2){
            i2 = 1;
        }
        return Result.resultStatus(i2);
    }

    //修改质检表入库状态
    public ResultData<Quality> updateQualitySS(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        int i = qualityService.updateQualitySS(id,name,user);
        return Result.resultStatus(i);
    }

    //修改质检表质检时间
    public ResultData<Quality> updateQualityTime(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Quality quality = new Quality();
        quality.setId(id);
        int i = qualityService.updateQualityTime(quality);
        return Result.resultStatus(i);
    }

    //删除质检表
    public ResultData<Quality> delQuality(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int i = qualityService.delQuality(id);
        return Result.resultStatus(i);
    }
    public ResultData<Quality> delQualityByOid(HttpServletRequest request, HttpServletResponse response){
        int oid = Integer.parseInt(request.getParameter("oid"));
        int i = qualityService.delQuality(oid);
        return Result.resultStatus(i);
    }

    //退货
    public ResultData<SalReturn> returnMedicine(HttpServletRequest request, HttpServletResponse response){
        int oId = Integer.parseInt(request.getParameter("oId"));
        int id = Integer.parseInt(request.getParameter("id"));
        int num = Integer.parseInt(request.getParameter("num"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        int i =0;
        if (num==1){
            i = salReturnService.addSalReturn(oId, id,name);
        }else {
            i = salReturnService.addSalReturnOne(oId,id,name);
        }

        return Result.resultStatus(i);
    }
    //更新有效期
    public ResultData<Quality> upUsefulLife(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String usefulLife = request.getParameter("usefulLife");
        Quality quality = new Quality();
        quality.setId(id);
        quality.setUsefulLife(usefulLife);
        int i = qualityService.upUsefulLife(quality);
        return Result.resultStatus(i);
    }
}
