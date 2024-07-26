package com.service.Impl;

import com.dao.MessageDao;
import com.pojo.Message;
import com.service.MessageService;
import com.util.BaseDao;
import org.apache.ibatis.session.SqlSession;

public class MessageServiceImpl implements MessageService {
    SqlSession session = BaseDao.getSqlSession();
    @Override
    public int addMessage(Message message) {
        return session.getMapper(MessageDao.class).addMessage(message);
    }
}
