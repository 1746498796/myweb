package com.wang.serviceImpl;

import com.wang.dao.LoginMapper;
import com.wang.pojo.Login;
import com.wang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Login queryByUserName(String userName) {
        return loginMapper.queryByUserName(userName);
    }
}
