package com.wang.uitls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ImgFile {

    public String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public String upload(MultipartFile file){
        //String val = getStringRandom(8);
        //获取上传文件名
        //String filename = file.getOriginalFilename();
        //定义上传文件保存路径
        //String path = filePath;
        // 新建文件
       // File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        //避免文件重复覆盖
        //String filename = null;
        String filename =null;
        try {
            filename= UUID.randomUUID().toString().replaceAll("-", "")+file.getOriginalFilename();
            //文件路径
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/picture/";
            // 新建文件
           // filename = uuid;
            File dest = new File(path,filename);

            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                // 写入文件
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return filename;
    }



}
