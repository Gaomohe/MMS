package com.dao;

import com.pojo.Middleman;
import com.util.ResultData;

public interface MiddlemanDao {
    public boolean updateMiddleMan(Middleman middleman);

    public boolean addMiddleMan(Middleman middleman);
}
