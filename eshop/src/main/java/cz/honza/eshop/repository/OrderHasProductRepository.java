package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Long> {

}
