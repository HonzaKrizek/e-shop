package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
