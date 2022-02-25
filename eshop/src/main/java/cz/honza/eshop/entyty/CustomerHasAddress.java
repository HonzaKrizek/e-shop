package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CustomerHasAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Address address;
}
