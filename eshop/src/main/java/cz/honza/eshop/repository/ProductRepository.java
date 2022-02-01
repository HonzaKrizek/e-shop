package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @EntityGraph(attributePaths = {"productInOrders"})
    Product findProductByNameContains(String contains);

    //@EntityGraph(attributePaths = {"productInOrders"})
    @Query("select p from Product p where p.id between 1 and 2")
    List<Product> findProductByIdBetween(Long start, Long finish);
}
