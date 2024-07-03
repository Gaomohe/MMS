package com.servlet;

import com.pojo.Menu;
import com.pojo.Supplier;
import com.pojo.User;
import com.service.Impl.SupplierServlceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.menuService;
@WebServlet("/supplier")
public class SupplierServlet extends BaseServlet {
    SupplierServlceImpl supplierServlce = new SupplierServlceImpl();
    //获取供应商所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/supplierManage/supplierList";
    }
    @Override
    public Class getServlet() {
        return SupplierServlet.class;
    }

    public void selectSupplier(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,supplierServlce.selectSupplier());
    }

    public ResultData delSupplier(HttpServletRequest request, HttpServletResponse response){
        return supplierServlce.delSupplier(Integer.parseInt(request.getParameter("supplierId")));
    }

    public ResultData selectSupplierById(HttpServletRequest request, HttpServletResponse response){
        return supplierServlce.selectSupplierById(Integer.parseInt(request.getParameter("supplierId")));
    }

    public ResultData checkSupplierName(HttpServletRequest request, HttpServletResponse response){
        return supplierServlce.checkSupplierName(request.getParameter("sname"));
    }
    public ResultData updateSupplier(HttpServletRequest request, HttpServletResponse response){
        Supplier supplier = new Supplier();
        supplier.setSid(Integer.parseInt(request.getParameter("supplierId")));
        supplier.setsName(request.getParameter("sname"));
        supplier.setOperationWay(request.getParameter("operationWay"));
        supplier.setTel(request.getParameter("tel"));
        supplier.setContact(request.getParameter("contact"));
        supplier.setStatus(request.getParameter("status"));
        supplier.setLicense(request.getParameter("license"));
        supplier.setCreateTime(request.getParameter("createTime"));
        return supplierServlce.updateSupplier(supplier);

    }
    public ResultData isUname(HttpServletRequest request, HttpServletResponse response){
        return supplierServlce.checkSupplierName(request.getParameter("sname"));
    }

    public ResultData addSupplier(HttpServletRequest request, HttpServletResponse response){
        Supplier supplier = new Supplier();
        supplier.setsName(request.getParameter("sname"));
        supplier.setOperationWay(request.getParameter("operationWay"));
        supplier.setTel(request.getParameter("tel"));
        supplier.setContact(request.getParameter("contact"));
        supplier.setStatus(request.getParameter("status"));
        supplier.setLicense(request.getParameter("license"));
        supplier.setCreateTime(request.getParameter("createTime"));
        return supplierServlce.addSupplier(supplier);
    }



}
