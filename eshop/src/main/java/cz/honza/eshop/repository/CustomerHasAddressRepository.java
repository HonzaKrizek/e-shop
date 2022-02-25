package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.CustomerHasAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerHasAddressRepository extends JpaRepository<CustomerHasAddress,Long> {
}
