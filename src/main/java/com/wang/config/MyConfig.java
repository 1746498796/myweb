package com.wang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
public class MyConfig implements WebMvcConfigurer {
//    /**显示相对地址*/
//    @Value("${file.upload.path.relative}")
//    private String fileRelativePath;
    //添加视图解析器方法重写
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//
//
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyHandlerIntercept())//使用addPathPattherns方法传入需要拦截的路径
//                .addPathPatterns("/**")
//                //然后在使用excludePatterns方法释放不需要拦截的路径
//                .excludePathPatterns("/index.html","/","/wang","/css/*","/js/*","/img/*","/image/*","/font/*","/picture/*","/toLogin");
//    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(fileRelativePath).addResourceLocations("file:/"+filePath);
//    }


}
