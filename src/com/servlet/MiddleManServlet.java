package com.servlet;

import com.pojo.Menu;
import com.pojo.Middleman;
import com.pojo.User;
import com.service.Impl.MiddlemanServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.menuService;

@WebServlet("/middleMan")
public class MiddleManServlet extends BaseServlet {
    MiddlemanServiceImpl middlemanService = new MiddlemanServiceImpl();
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){

        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/middleManManage/middleManList";
    }

    @Override
    public Class getServlet() {
        return MiddleManServlet.class;
    }

    public void selectMiddleMan(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,middlemanService.selectMiddleMan(page,limit));
    }
    public ResultData delMiddleMan(HttpServletRequest request, HttpServletResponse response){
        return middlemanService.delMiddleMan(Integer.parseInt(request.getParameter("workId")));
    }
    public ResultData selectMiddleManById(HttpServletRequest request, HttpServletResponse response){
        return middlemanService.selectMiddleManById(Integer.parseInt(request.getParameter("workId")));
    }
    public ResultData checkMiddleManName(HttpServletRequest request, HttpServletResponse response){
        return middlemanService.checkMiddleManName(request.getParameter("mname"));
    }
    public ResultData updateMiddleMan(HttpServletRequest request, HttpServletResponse response){
        Middleman middleman = new Middleman();
        middleman.setmName(request.getParameter("mname"));
        middleman.setWorkId(Integer.parseInt(request.getParameter("workId")));
        middleman.setMedNum(Integer.parseInt(request.getParameter("medNum")));
        middleman.setTel(request.getParameter("tel"));
        middleman.setEmail(request.getParameter("email"));
        middleman.setDepartment(request.getParameter("department"));
        middleman.setMedName(request.getParameter("medName"));
        middleman.setStandard(request.getParameter("standard"));
        middleman.setDate(request.getParameter("date"));
        middleman.setPlace(request.getParameter("place"));
        return middlemanService.updateMiddleMan(middleman);
    }
    public ResultData isUname(HttpServletRequest request, HttpServletResponse response){
        return middlemanService.checkMiddleManName(request.getParameter("mname"));
    }
    public ResultData addMiddleMan(HttpServletRequest request, HttpServletResponse response){
        Middleman middleman = new Middleman();
        middleman.setmName(request.getParameter("mname"));
        middleman.setMedNum(Integer.parseInt(request.getParameter("medNum")));
        middleman.setTel(request.getParameter("tel"));
        middleman.setEmail(request.getParameter("email"));
        middleman.setDepartment(request.getParameter("department"));
        middleman.setMedName(request.getParameter("medName"));
        middleman.setStandard(request.getParameter("standard"));
        middleman.setDate(request.getParameter("date"));
        middleman.setPlace(request.getParameter("place"));
        return middlemanService.addMiddleMan(middleman);
    }


}
