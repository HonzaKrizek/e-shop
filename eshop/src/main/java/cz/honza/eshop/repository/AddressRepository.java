package cz.honza.eshop.repository;

import cz.honza.eshop.entyty.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
