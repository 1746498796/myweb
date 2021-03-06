package com.wang.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wang.pojo.Comprofile;
import com.wang.serviceImpl.ComprofileServiceImpl;
import com.wang.uitls.ImgFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@PropertySource("application.properties")
public class ComprofileController {

    @Autowired
    ComprofileServiceImpl comprofileService;
    @Autowired
    ImgFile imgFile;

    @RequestMapping("/user/comprofilelist")
    private String comprofileList(Model model){
        Comprofile comprofile = comprofileService.queryAll();
        model.addAttribute("comprofile",comprofile);
        return "comm/comprofilelist";
    }

    @RequestMapping("/user/updatecomfrofileHtml")
    public String  updatecomfrofileHtml(Model model){
        Comprofile comprofile = comprofileService.queryAll();
        model.addAttribute("comprofile",comprofile);
        return "comm/updatecomfrofile";
    }



    @RequestMapping("/user/updatecomfrofile")
    public String updatecomfrofile(MultipartFile file, Comprofile comprofile){
        //String val = imgFile.getStringRandom(8);
        //String filename = val+file.getOriginalFilename();
        //System.out.println(comprofile);
//        comprofile.setImgname(filename);
//        System.out.println(filename);
//        imgFile.upload(file,filename);
//        int i = comprofileService.updateByID(comprofile);
        if (file.getOriginalFilename().isEmpty()){
            comprofileService.updateByID(comprofile);
        }else {
            String upload = imgFile.upload(file);
            comprofile.setImgname(upload);
            comprofileService.updateByID(comprofile);
        }
        System.out.println("????????????");
        return "redirect:/user/comprofilelist";
    }


}
