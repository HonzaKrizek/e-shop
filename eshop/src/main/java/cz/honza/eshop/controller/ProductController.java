package cz.honza.eshop.controller;

import cz.honza.eshop.dto.AddOrEditProductDto;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.repository.ProductRepository;
import cz.honza.eshop.service.FileService;
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
    @Autowired
    private FileService fileService;


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

            AddOrEditProductDto dto = new AddOrEditProductDto();
            dto.setId(byId.getId());
            dto.setName(byId.getName());
            dto.setPrice(byId.getPrice());
            dto.setDescription(byId.getDescription());

            model.addAttribute("product", dto);
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
        product.setPrice(addOrEditProduct.getPrice());
        product.setDescription(addOrEditProduct.getDescription());

        String fileName = fileService.upload(addOrEditProduct.getImage());
        product.setPathToImage(fileName);
        productRepository.save(product);
        return "redirect:/";
    }

}
