package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
