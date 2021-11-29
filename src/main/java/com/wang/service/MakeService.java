package com.wang.service;

import com.wang.pojo.Make;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MakeService {

    List<Make> queryAll();

    int updateByID(Make make);

    Make queryByID(int id);
}
