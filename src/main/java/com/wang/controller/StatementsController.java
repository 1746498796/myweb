package com.wang.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wang.pojo.Statements;
import com.wang.serviceImpl.StatementsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StatementsController {

    @Autowired
    StatementsServiceImpl statementsService;

    @RequestMapping("/user/statementslistHtml")
    public  String statementslistHtml(Model model){
        List<Statements> statements = statementsService.queryAll();
        model.addAttribute("statements",statements);
        return "/comm/statementslist";
    }

    @RequestMapping("/user/updateStatementsHtml")
    public String updateStatementsHtml(int id,Model model){
        Statements statement = statementsService.queryByID(id);
        model.addAttribute("statement",statement);

        return "/comm/updateStatements";
    }

    @RequestMapping("/user/updateStatements")
    public String updateStatements(Statements statements,Model model){
       statementsService.upDateByID(statements);
        return "redirect:/user/statementslistHtml";
    }

    @RequestMapping("/user/insertstatementsHtml")
    public String insertstatementsHtml(int id, Model model){
        //List<Statements> statements = statementsService.queryAll();
        System.out.println(id);
        model.addAttribute("id",id);
        return "/comm/insertStatements";
    }



    @RequestMapping("/user/insertstatements")
    public String insertstatements(Statements statements){
        statementsService.insertOne(statements);
        return "redirect:/user/statementslistHtml";
    }



    @RequestMapping("/user/deletestatement")
    public  String deletestatement(int id){
        statementsService.deleteByID(id);
        return "redirect:/user/statementslistHtml";
    }
}
