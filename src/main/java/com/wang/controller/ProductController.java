package com.wang.controller;
import com.wang.pojo.Product;
import com.wang.serviceImpl.ProductServiceImpl;
import com.wang.uitls.ImgFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@PropertySource("application.properties")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    private ImgFile imgFile;

    @RequestMapping("/user/queryProduct")
    public String queryProduct(Model model){
        List<Product> products = productService.queryALl();
        model.addAttribute("products",products);
        String val = imgFile.getStringRandom(8);
        model.addAttribute("val",val);
        return "comm/productlist";
    }

    @RequestMapping("/user/addproduct")
    public String addproduct(int id,Model model){
        Product product = productService.queryByID(id);
        model.addAttribute("product",product);

        return "comm/addproduct";
    }


    @RequestMapping("/user/imgfile")
    public String imgFile(MultipartFile file, Product product ,Model model){
        if (file.getOriginalFilename().isEmpty()){
           productService.updateProduct(product);
        }else {
                try{
                    String filename = imgFile.upload(file);
                    product.setImgname(filename);
                    int i = productService.updateProduct(product);
                    System.out.println(filename);
                }catch (Exception e){
                    System.out.println("上传文件的地方出错了");
                }
        }
        return "redirect:/user/queryProduct";
    }


    @RequestMapping("/user/insertproductHtml")
    public  String insertproductHtml(int id,Model model){
        model.addAttribute("id",id);
        return "comm/insertproduct";
    }
    @PostMapping("/user/insertproduct")
    public  String insertproduct(MultipartFile file,Product product,Model model){
        String filename = imgFile.upload(file);
        product.setImgname(filename);
        int i = productService.updateProduct(product);
        productService.insertProduct(product);
        return "redirect:/user/queryProduct";
    }


    @RequestMapping("/user/deleteproduct")
    public String deleteproduct(int id){
        productService.deleteProduct(id);
        return "redirect:/user/queryProduct";
    }
}
