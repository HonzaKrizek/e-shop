package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM ProductHasReview phr JOIN phr.product p JOIN phr.review r WHERE p.id = ?1")
    List<Review> findReviewByProductId(Long productId);

    @Query("SELECT AVG(r.rating) FROM ProductHasReview phr JOIN phr.product p JOIN phr.review r WHERE p.id = ?1")
    Double findAverageOfRatingByProductId(Long productId);
}
