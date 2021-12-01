package com.wang.controller;

import com.wang.pojo.Make;
import com.wang.serviceImpl.MakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class MakeController {
    @Autowired
    private MakeServiceImpl makeService;
    @RequestMapping("/user/makelist")
    public String makelist(Model model){
        List<Make> makes = makeService.queryAll();
        model.addAttribute("makes",makes);
        return "comm/makelist";
    }

    @RequestMapping("/user/updatemake")
    public  String updateMakeHtml(int id , Model model){

        Make make = makeService.queryByID(id);
        model.addAttribute("make",make);

        return "comm/updateMake";
    }




    @RequestMapping("/user/updatemk")
    public String updateMake(Make make){
        int i = makeService.updateByID(make);
        System.out.println("修改成功");
        return "redirect:/user/makelist";
    }

}

