package com.servlet;

import com.dao.Impl.PurchaseDaoImpl;
import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Menu;
import com.pojo.User;
import com.service.AppointService;
import com.service.Impl.AppointServiceImpl;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/appoint")
public class AppointServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return AppointServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","采购申请","获取界面所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/shoppingManage/appointmentOrder/appointList";
    }

    //获取所有采购申请信息
    public void getAllAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","获取所有采购申请信息");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,appointService.getAppointList(page,limit));
    }

    //删除采购申请
    public ResultData delAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","删除采购申请");
        String ids = request.getParameter("ids");
        System.out.println(ids.toString());
        int mId = Integer.parseInt(ids);
        int i = appointService.delAppoint(mId);
        return Result.resultStatus(i);
    }

    //订单详情数据回显
    public void selectAppoint(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            // 获取 idsList 参数
            String[] idStrArray = request.getParameterValues("idsList");
            List<Integer> idList = new ArrayList<>();

            // 如果 idStrArray 不为空，处理单一字符串
            if (idStrArray != null && idStrArray.length > 0) {
                String idStr = idStrArray[0]; // 获取第一个（也是唯一一个）参数值
                String[] ids = idStr.split(","); // 按逗号分割

                for (String id : ids) {
                    try {
                        idList.add(Integer.parseInt(id.trim())); // 将字符串转换为整数
                    } catch (NumberFormatException e) {
                        e.printStackTrace(); // 打印解析异常
                    }
                }
            }
            applyIdsList = idList;
            session.setAttribute("addIdsList",idList);

            // 获取数据
            LayuiTable<Appointment> appointmentList = appointService.selectAppoint(idList);

            // 返回 JSON 响应
            ToJSON.toJson(response, appointmentList);

        } catch (Exception e) {
            e.printStackTrace(); // 打印异常
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                response.getWriter().write("An error occurred while processing the request.");
            } catch (Exception ioException) {
                ioException.printStackTrace(); // 处理写入响应时的异常
            }
        }
    }



    //采购申请
    public ResultData addAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","提交采购申请");
        String[] idStr = request.getParameterValues("idsList");
        List<Integer> idList = Format.StringToInt(idStr);
        int i = appointService.addAppoint(idList);
        new PurchaseDaoImpl().isOK_msg(0,"预警信息","您的药品申请已经发出,请耐心等待审批结果!",1001,1001);
        return Result.resultStatus(i);
    }

    //获取供应商
    public void getSupplier(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getSupplier());
    }

    //获取药品类型
    public void getmType(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getmType());
    }

    //获取药品名称
    public void getmName(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getmName());
    }

    //条件查询所有预购表信息
    public void Search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        String pageStr = request.getParameter("page");
        String limitStr = request.getParameter("limit");
        int page = Integer.parseInt(pageStr);
        int limit = Integer.parseInt(limitStr);
        logService.setLog(name,"查询","预购订单","查询预购订单表");
        String supplierName = request.getParameter("supplierName");
        String mTypeName = request.getParameter("mTypeName");
        String mNameName = request.getParameter("mNameName");
        Apply apply = new Apply();
        apply.setSupplier(supplierName);
        apply.setmType(mTypeName);
        apply.setmName(mNameName);
        page = (page-1)*limit;
        LayuiTable<Apply> search = appointService.Search(apply, page, limit);
        ToJSON.toJson(response,search);
    }

    //确认添加预购订单
    public ResultData Submit(HttpServletRequest request, HttpServletResponse response){
        int i = appointService.Submit(applyIdsList);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }

    //获取供应商
    public void getStatistics(HttpServletRequest request, HttpServletResponse response){
        List<Apply> applyList = appointService.getStatistics();
        ToJSON.toJson(response,applyList);
    }
}