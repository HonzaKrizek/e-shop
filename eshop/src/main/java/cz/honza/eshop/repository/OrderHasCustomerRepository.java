package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.OrderHasCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasCustomerRepository extends JpaRepository<OrderHasCustomer,Long> {
}
