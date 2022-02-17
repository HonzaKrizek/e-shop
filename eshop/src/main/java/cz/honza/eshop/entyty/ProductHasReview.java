package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductHasReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Review review;


}
