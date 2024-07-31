package com.servlet;

import com.pojo.ApplyFailed;
import com.pojo.Medicine;
import com.pojo.Menu;
import com.pojo.User;
import com.service.ApplyFaileService;
import com.service.Impl.ApplyFailedServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/applyFailed")
public class ApplyFailedServlet extends BaseServlet {

    ApplyFaileService applyFaileService = new ApplyFailedServiceImpl();
    @Override
    public Class getServlet() {
        return ApplyFailedServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","不合格品处理","获取界面所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        List<String> mType = applyFaileService.getMType();
        List<String> allManufactor = applyFaileService.getAllManufactor();
        session1.setAttribute("mType",mType);
        session2.setAttribute("manufactor",allManufactor);
        session.setAttribute("menuList",menuList);
        return "medicine/qualityManage/defectiveDisposal/failedList";
    }

    //添加不合格处理数据
    public ResultData<ApplyFailed> addFailed(HttpServletRequest request, HttpServletResponse response){
        String tableCoding = request.getParameter("tableCoding");
        String id = request.getParameter("id");
        String cause = request.getParameter("cause");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        int i = applyFaileService.addFailed(Integer.parseInt(tableCoding), cause,name,Integer.parseInt(id));
        return Result.resultStatus(i);
    }

    //获取所有不合格处理数据
    public LayuiTable<ApplyFailed> getAllApplyFailed(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String sort = request.getParameter("sort");
        String title = request.getParameter("order");
        int i = applyFaileService.getAll();
        LayuiTable<ApplyFailed> layuiTable = new LayuiTable<>();
        if (title==null){
            List<ApplyFailed> allMedicine = applyFaileService.getAll(page,limit);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(allMedicine);
            layuiTable.setMsg("操作成功");
        }else {
            List<ApplyFailed> allMedicine = applyFaileService.getAll(page,limit,title,sort);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(allMedicine);
            layuiTable.setMsg("操作成功");
        }
        return layuiTable;
    }

    //添加处理历史记录
    public ResultData<ApplyFailed> getCause(HttpServletRequest request, HttpServletResponse response){
        int applyId = Integer.parseInt(request.getParameter("applyId"));
        List<ApplyFailed> list = applyFaileService.getAllCase(applyId);
        return Result.resultData(list);
    }

    //根据ID获取数据
    public ResultData<ApplyFailed> getApplyFailedByAId(HttpServletRequest request, HttpServletResponse response){
        String applyId = request.getParameter("applyId");
        ApplyFailed applyFailedByAId = applyFaileService.getApplyFailedByAId(Integer.parseInt(applyId));
        return Result.resultData(applyFailedByAId);
    }

    //根据名称获取数据
    public ResultData<ApplyFailed> getApplyFailedByMName(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        List<ApplyFailed> applyFailedByMName = applyFaileService.getApplyFailedByMName(name);
        return Result.resultData(applyFailedByMName);
    }
    //根据mType获取数据
    public ResultData<ApplyFailed> getApplyFailedByMType(HttpServletRequest request, HttpServletResponse response){
        String mType = request.getParameter("mType");
        List<ApplyFailed> applyFailedByMName = applyFaileService.getApplyFailedByMType(mType);
        return Result.resultData(applyFailedByMName);
    }

    //根据manufactor获取数据
    public ResultData<ApplyFailed> getApplyFailedByManufactor(HttpServletRequest request, HttpServletResponse response){
        String manufactor = request.getParameter("manufactor");
        List<ApplyFailed> applyFailedByMName = applyFaileService.getApplyFailedByManufactor(manufactor);
        return Result.resultData(applyFailedByMName);
    }

    //删除数据
    public ResultData<ApplyFailed> delApplyFailed(HttpServletRequest request, HttpServletResponse response){
        String applyId = request.getParameter("applyId");
        int i = applyFaileService.delApplyFailed(Integer.parseInt(applyId));
        return Result.resultData(i);
    }
    //修改审批状态
    public ResultData<ApplyFailed> updateAppFailed(HttpServletRequest request, HttpServletResponse response){
        String applyId = request.getParameter("applyId");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        user.setUserName(userDao.getUserName(user.getId()));
        int i = applyFaileService.updateAppFailed(Integer.parseInt(applyId),user.getUserName());
        return Result.resultData(i);
    }
    //修改不合格原因
    public ResultData<ApplyFailed> updateCause(HttpServletRequest request, HttpServletResponse response){
        String applyId = request.getParameter("applyId");
        String cause = request.getParameter("cause");
        int i = applyFaileService.updateCause(cause,Integer.parseInt(applyId));
        return Result.resultData(i);
    }
}
