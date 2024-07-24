package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class BaseDao {
    public static InputStream resourceAsStream = null;
    public static SqlSessionFactory sqlSessionFactory = null;

    static {
        try{
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession session = sqlSessionFactory.openSession(true);
        return session;
    }
}