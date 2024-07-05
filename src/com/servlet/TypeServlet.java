package com.servlet;

import com.pojo.Type;
import com.service.Impl.TypeServiceImpl;
import com.service.TypeService;
import com.util.BaseServlet;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/type")
public class TypeServlet extends BaseServlet {

    TypeService typeService  = new TypeServiceImpl();
    @Override
    public Class getServlet() {
        return TypeServlet.class;
    }
    //显示分类
    public ResultData<Type> getGoodsType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllGoodsType();
        return Result.resultData(allGoodsType);
    }
    public ResultData<Type> getMType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllMType();
        return Result.resultData(allGoodsType);
    }
    public ResultData<Type> getfreeType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllfreeType();
        return Result.resultData(allGoodsType);
    }
    public ResultData<Type> getdosage(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAlldosage();
        return Result.resultData(allGoodsType);
    }


    //添加分类
    public ResultData<Type> addGoodsType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("type");
        Type type = new Type();
        type.setTypename(s);
        int i = typeService.addGoodsType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> addMType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("type");
        Type type = new Type();
        type.setTypename(s);
        int i = typeService.addMType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> addfreeType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("type");
        Type type = new Type();
        type.setTypename(s);
        int i = typeService.addfreeType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> adddosage(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("type");
        Type type = new Type();
        type.setTypename(s);
        int i = typeService.dosage(type);
        return Result.resultStatus(i);
    }
    //删除分类
    public ResultData<Type> delGoodsType(HttpServletRequest request, HttpServletResponse response){
        String type = request.getParameter("type");
        int i = typeService.delGoodsType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> delMType(HttpServletRequest request, HttpServletResponse response){
        String type = request.getParameter("type");
        int i = typeService.delMType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> delfreeType(HttpServletRequest request, HttpServletResponse response){
        String type = request.getParameter("type");
        int i = typeService.delfreeType(type);
        return Result.resultStatus(i);
    }
    public ResultData<Type> deldosage(HttpServletRequest request, HttpServletResponse response){
        String type = request.getParameter("type");
        int i = typeService.deldosage(type);
        return Result.resultStatus(i);
    }
}
