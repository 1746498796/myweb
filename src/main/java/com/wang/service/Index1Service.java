package com.wang.service;

import com.wang.pojo.Index1;
import org.apache.ibatis.annotations.Param;

public interface  Index1Service {
    Index1 queryAll();
    int updateAll(Index1 index1);

    int updatemp4name(String mp4name);
    String querymp4name();
}
