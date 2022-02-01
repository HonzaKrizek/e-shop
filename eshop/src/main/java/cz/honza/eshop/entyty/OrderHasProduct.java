package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private Integer amount;
}
