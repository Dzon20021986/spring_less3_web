package ru.geekbrains.spring_less3_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less3_web.Model.Product;
import ru.geekbrains.spring_less3_web.Repository.ProductRepository;
import ru.geekbrains.spring_less3_web.Service.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String getTest(Model model, @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute("twr", product);
        return "product_page";
    }

    @GetMapping("/product/all")
    public String getTest(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product_info_page";
    }


    //http://localhost/app/add
    @GetMapping("/add")
    @ResponseBody
    public String add() {
        return "hello";
    }

    //http://localhost/app/sum?param=1&param1=2
    @GetMapping("/sum")
    @ResponseBody
    public int sum(@RequestParam (name ="param", required = false) int a, @RequestParam(name ="param1") int b) {
        return a + b;
    }

//    @GetMapping("/test")
//    @ResponseBody
//    public String sum(@RequestParam (name ="param") String a, @RequestParam(name ="param1") String b) {
//        return a + b;
//    }

    //http://localhost/app/test/2
    @GetMapping("/client/{id}/info")
    @ResponseBody
    public String findById(@PathVariable long id) {
        return "Client # " + id;
    }

//    @GetMapping("/div")
//    @ResponseBody
//    public String div() {
//        return "div";
//    }

}
