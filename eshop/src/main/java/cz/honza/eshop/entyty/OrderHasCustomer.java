package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderHasCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Customer customer;
}
