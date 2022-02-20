package cz.honza.eshop.controller;

import cz.honza.eshop.dto.AddOrEditReviewDto;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.entyty.ProductHasReview;
import cz.honza.eshop.entyty.Review;
import cz.honza.eshop.repository.ProductHasReviewRepository;
import cz.honza.eshop.repository.ProductRepository;
import cz.honza.eshop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductHasReviewRepository productHasReviewRepository;


    @PostMapping("/review-process/{productId}")
    public String productDetailReviewProcess(@PathVariable(required = false) Long productId, AddOrEditReviewDto addOrEditReviewDto){
        Review review = new Review();
        review.setId(addOrEditReviewDto.getId());
        review.setNick(addOrEditReviewDto.getNick());
        review.setEvaluation(addOrEditReviewDto.getEvaluation());
        review.setRating(addOrEditReviewDto.getRating());
        reviewRepository.save(review);

        Product product = productRepository.findById(productId).get();

        ProductHasReview productHasReview = new ProductHasReview();
        productHasReview.setProduct(product);
        productHasReview.setReview(review);
        productHasReviewRepository.save(productHasReview);
        return "redirect:/product-detail/"+productId;
    }
}
