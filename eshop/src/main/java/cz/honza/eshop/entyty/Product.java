package cz.honza.eshop.entyty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private TypeEnum type;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private SubtypeEnum subtype;


    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> productInOrders;

    @OneToMany(mappedBy = "id")
    private Set<ProductHasReview> productHasReviews;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
