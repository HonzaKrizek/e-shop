package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generace automatického klíče
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private String pathToImage;

    //@Lob
    //private byte[] image;


    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> productInOrders;
}
