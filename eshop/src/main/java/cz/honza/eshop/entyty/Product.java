package cz.honza.eshop.entyty;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generace automatického klíče
    private Long id;

    private String name;

    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> productInOrders;
}
