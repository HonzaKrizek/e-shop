package cz.honza.eshop.controller;

import cz.honza.eshop.dto.AddOrEditProductDto;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {


    @Autowired
    private ProductRepository productRepository;


    @ExceptionHandler(RuntimeException.class)
    public String handleExceptions(){
        return "error";
    }

    @GetMapping("/")
    public String showAllProducts(Model model){
        model.addAttribute("productList", productRepository.findAll(Sort.by(Sort.Direction.ASC,"id")));
        return "product-list";
    }

    @GetMapping("/product-detail/{id}")
    public String showProductDetail(@PathVariable(required = false) Long id, Model model){
            model.addAttribute("product", productRepository.findById(id).get());
            return "product-detail";
    }

    @GetMapping(value = {"/product-form", "/product-form/{id}"})
    public String showProductForm(@PathVariable(required = false) Long id, Model model){
        if(id != null){
            Product byId = productRepository.findById(id).orElse(new Product());
            model.addAttribute("product", byId);
        }
        else {
            model.addAttribute("product", new AddOrEditProductDto());
        }
        return "product-form";
    }

    @PostMapping("/product-form-process")
    public String productFormProcess(AddOrEditProductDto addOrEditProduct){
        Product product = new Product();
        product.setId(addOrEditProduct.getId());
        product.setName(addOrEditProduct.getName());
        productRepository.save(product);
        return "redirect:/";
    }
}
