package com.wang.controller;

import com.wang.pojo.Index1;
import com.wang.pojo.Make;
import com.wang.serviceImpl.Index1ServiceImpl;
import com.wang.serviceImpl.MakeServiceImpl;
import com.wang.uitls.ImgFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@PropertySource("application.properties")
public class Index1Controller {

    @Autowired
    private Index1ServiceImpl index1Service;

    @Autowired
    private ImgFile imgFile;
    @RequestMapping("/user/list")
    public String list(Model model){
        Index1 index1 = index1Service.queryAll();
        String stringRandom = imgFile.getStringRandom(8);
        model.addAttribute("stringRandom",stringRandom);
        model.addAttribute("index1",index1);
        return "comm/list";
    }

    @RequestMapping("/user/query")
    public String query(Model model){
        Index1 index1 = index1Service.queryAll();
        model.addAttribute("index1",index1);
        return "comm/qurey";
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

    @RequestMapping("/vdieo")
    public String vdieo(Model model){
        String mp4name = index1Service.querymp4name();
        model.addAttribute("mp4name",mp4name);
        return "vdieo";
    }

    @RequestMapping("/user/updatevideohtml")
    public String updateVideoHtml(Model model){
        String mp4name = index1Service.querymp4name();
        model.addAttribute("mp4name",mp4name);
        return "comm/updateMp4";
    }
    @PostMapping("/user/updatevideo")
    public String updateVideo(MultipartFile file123,String mp4name,Model model){
        imgFile.upload2(file123,mp4name);
        return "redirect:/user/list";
    }
    @RequestMapping("/yaml")
    @ResponseBody
    public String yaml(){
        String stringRandom = imgFile.getStringRandom(8);
        return stringRandom;
    }


}
