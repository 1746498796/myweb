package com.wang.controller;


import com.wang.pojo.*;

import com.wang.serviceImpl.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class OutController {
    @Autowired
    private Index1ServiceImpl index1Service;
    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ComprofileServiceImpl comprofileService;

    @Autowired
    private MakeServiceImpl makeService;
    @Autowired
    private StatementsServiceImpl statementsService;
    @Autowired
    private ContactServiceImpl contactService;
//    public void setLoginService(LoginService loginService) {
//        this.loginService = loginService;
//    }

    @RequestMapping({"/","/index"})
    public String index(Model model){
        int i = 1;
        Index1 index1 = index1Service.queryAll();
        model.addAttribute("index1",index1);
        List<Product> products = productService.queryALl();
        model.addAttribute("products",products);
        List<Make> makes = makeService.queryAll();
        model.addAttribute("makes",makes);
        Comprofile comprofile = comprofileService.queryAll();
        model.addAttribute("comprofile",comprofile);
        List<Statements> statements = statementsService.queryAll();
        model.addAttribute("statements",statements);
        Contact contact = contactService.queryAll();
        model.addAttribute("contact",contact);
        return "index";
    }


    //后台登录页

    @GetMapping("/wang")
    public String login(){
        return "outindex";
    }

   /* @PostMapping("/toLogin")
    @ResponseBody
    public Map<Object,Object> toLogin(String username, String password, HttpSession session){
        System.out.println(username);
        System.out.println(password);
        Login login = loginService.queryByUserName(username);
        System.out.println(login);
        Map<Object, Object> map = new HashMap<>();
        if (login!=null){
            System.out.println("不为空");
            if (login.getPassWord().equals(password)){
                System.out.println("相同");
                map.put("msg","true");
                session.setAttribute("loginSession",username);
                return map;
            }else {
                System.out.println("不同");
                map.put("msg","false");
                return map;
            }

        }else {
            System.out.println("为空");
            map.put("msg","false");
            return map;
        }

    }*/


    @PostMapping("/toLogin")
    public String toLogin(String username, String password,Model model){
        System.out.println(username);
        System.out.println(password);
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        //将账户密码封装成一个Token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);//执行登录的方法

            return "dashboard.html";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "/wang";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","用户名不存在");
            return "/wang";
        }

    }


    @RequestMapping("/user/main")
    public String main(){

        return "dashboard";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index";
    }

    @RequestMapping("/wsq")
    public String wsq(){
        return "/wsq";
    }

}
