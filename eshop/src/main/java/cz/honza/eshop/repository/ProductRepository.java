package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findProductByNameContains(String contains);

    List<Product> findProductByIdBetween(Long start, Long finish);
}
