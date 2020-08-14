package com.zynb.controller;

import com.github.pagehelper.PageInfo;
import com.zynb.domain.Product;
import com.zynb.exception.MyException;
import com.zynb.service.IProductService;
import com.zynb.vo.PUVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
//@ResponseBody
//@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> list = productService.getlist();
        modelAndView.setViewName("product/productList");
        modelAndView.addObject("productList",list);
        return modelAndView;
    }

    @RequestMapping("/page")
    public ModelAndView page(){
        return new ModelAndView("product/list");
    }

    @RequestMapping("/date")
    @ResponseBody
    public Map date(HttpServletRequest request) throws Exception {
        PageInfo<Product> pageInfo = productService.getpage(Integer.parseInt(request.getParameter("page")), Integer.parseInt(request.getParameter("limit")));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", pageInfo.getList());
        map.put("code", 0);
        map.put("msg", "123");
        map.put("count", pageInfo.getTotal());
        return map;
    }

/*    @RequestMapping("/date")
    public void date(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageInfo<Product> pageInfo = productService.getpage(Integer.parseInt(request.getParameter("page")), Integer.parseInt(request.getParameter("limit")));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", pageInfo.getList());
        map.put("code", 0);
        map.put("msg", "123");
        map.put("count", pageInfo.getTotal());
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(map));
    }*/

    @RequestMapping("/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable("id")Integer id){
        ModelAndView modelAndView = new ModelAndView("jsp/index");
        Product product = productService.findById(id);
        modelAndView.setViewName("product/productItem");
        modelAndView.addObject("item",product);
        return modelAndView;
    }

    @RequestMapping("/doUpdate")
    public ModelAndView doUpdate(Product product, MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        String originalFilename = pictureFile.getOriginalFilename();
        if(originalFilename!=""){
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString()+suffix;
            String uploadPath = request.getServletContext().getRealPath("upload");
            pictureFile.transferTo(new File(uploadPath,fileName));
            product.setPic(fileName);
        }
        productService.update(product);
        return list();
    }

    @RequestMapping("/mohu")
    public ModelAndView mohu(PUVO puvo){
        System.out.println(puvo);
        return null;
    }

    @RequestMapping("/test1")
    public Product test1(Product product){
        System.out.println(product);
        product.setName("收到了");
        product.setPrice(Float.parseFloat("250"));
        return product;
    }

    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("name","来了来了");
        return "bbb";
    }

    @RequestMapping("/test3")
    public String test3(Model model){
        return "forward:/product/page";
    }

    @RequestMapping("/test4")
    public String test4(Model model){
        return "redirect:/product/page";
    }

    @RequestMapping("/test5")
    public String test5(Model model){
        int i=1/0;
        return "redirect:/product/page";
    }

    @RequestMapping("/test6")
    public String test6(Model model) throws MyException {
        throw new MyException("现在可能是我有问题");
        //return "redirect:/product/page";
    }
}
