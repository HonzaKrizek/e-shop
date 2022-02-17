package cz.honza.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {




    @PostMapping("/review-process/{id}")
    public String productDetailReviewProcess(@PathVariable(required = false) Long id){

        return "redirect:/product-detail/"+id;
    }
}
