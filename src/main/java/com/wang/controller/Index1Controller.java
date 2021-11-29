package com.wang.controller;

import com.wang.pojo.Index1;
import com.wang.pojo.Make;
import com.wang.serviceImpl.Index1ServiceImpl;
import com.wang.serviceImpl.MakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Index1Controller {

    @Autowired
    private Index1ServiceImpl index1Service;

    @Autowired
    private MakeServiceImpl makeService;

    @RequestMapping("/user/list")
    public String list(Model model){
        Index1 index1 = index1Service.queryAll();
        model.addAttribute("index1",index1);
        return "/comm/list";
    }

    @RequestMapping("/user/query")
    public String query(Model model){
        Index1 index1 = index1Service.queryAll();
        model.addAttribute("index1",index1);
        return "/comm/qurey";
    }

    @PostMapping("/user/update")
    public String update(Index1 index1){
        System.out.println(index1);

        int i = index1Service.updateAll(index1);
        if (i>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        return "redirect:/user/list";
    }
}
