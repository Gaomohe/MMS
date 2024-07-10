package com.servlet;

import com.pojo.Type;
import com.service.Impl.TypeServiceImpl;
import com.service.TypeService;
import com.util.BaseServlet;
import com.util.LayuiTable;
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
    public LayuiTable<Type> getGoodsType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllGoodsType();
        LayuiTable layuiTable = new LayuiTable();
        layuiTable.setCode(0);
        layuiTable.setData(allGoodsType);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }
    public LayuiTable<Type> getMType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllMType();
        LayuiTable layuiTable = new LayuiTable();
        layuiTable.setCode(0);
        layuiTable.setData(allGoodsType);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }
    public LayuiTable<Type> getfreeType(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllfreeType();
        LayuiTable layuiTable = new LayuiTable();
        layuiTable.setCode(0);
        layuiTable.setData(allGoodsType);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }
    public LayuiTable<Type> getdosage(HttpServletRequest request, HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAlldosage();
        LayuiTable layuiTable = new LayuiTable();
        layuiTable.setCode(0);
        layuiTable.setData(allGoodsType);
        layuiTable.setMsg("操作成功");
        return layuiTable;
    }

    //重名验证
    public ResultData<Type> isGoodsType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("typename");
        Type allGoodsType = typeService.isAllGoodsType(s);
        int i = 0;
        System.out.println(allGoodsType.getTypename());
        if (allGoodsType.getTypename() != null){
            i=1;
        }
        return Result.resultNameStatus(i);
    }
    public ResultData<Type> isMType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("typename");
        Type allGoodsType = typeService.isAllMType(s);
        int i = 0;
        System.out.println(allGoodsType.getTypename());
        if (allGoodsType.getTypename() != null){
            i=1;
        }
        return Result.resultNameStatus(i);
    }
    public ResultData<Type> isfreeType(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("typename");
        Type allGoodsType = typeService.isAllfreeType(s);
        int i = 0;
        System.out.println(allGoodsType.getTypename());
        if (allGoodsType.getTypename() != null){
            i=1;
        }
        return Result.resultNameStatus(i);
    }
    public ResultData<Type> isdosage(HttpServletRequest request, HttpServletResponse response){
        String s = request.getParameter("typename");
        Type allGoodsType = typeService.isAlldosage(s);
        int i = 0;
        System.out.println(allGoodsType.getTypename());
        if (allGoodsType.getTypename() != null){
            i=1;
        }
        return Result.resultNameStatus(i);
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
        System.out.println(type);
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
