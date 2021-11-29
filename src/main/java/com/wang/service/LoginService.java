package com.wang.service;

import com.wang.pojo.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginService {
    Login queryByUserName(String userName);
}
