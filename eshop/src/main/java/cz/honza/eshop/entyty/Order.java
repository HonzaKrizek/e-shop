package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orderForm")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private StateEnum state;

    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> orderHasProducts;

}
