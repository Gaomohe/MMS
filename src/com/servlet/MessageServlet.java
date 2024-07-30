package com.servlet;

import com.dao.UserDao;
import com.pojo.Message;
import com.pojo.User;
import com.service.Impl.MessageServiceImpl;
import com.service.MessageService;
import com.util.BaseServlet;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.util.Vessel.userDao;


@WebServlet("/message")
public class MessageServlet extends BaseServlet {

    MessageService messageService = new MessageServiceImpl();
    @Override
    public Class getServlet() {
        return MessageServlet.class;
    }

    //新增预警信息
    public ResultData<Message> addMessageByWId(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String userName = userDao.getUserName(user.getId());
        String message = request.getParameter("message");
        String wId = request.getParameter("wId");
        Message message1 = new Message(user.getId(),userName,Integer.parseInt(wId),message);
        int i = messageService.addMessage(message1);
        return Result.resultStatus(i);
    }
}
