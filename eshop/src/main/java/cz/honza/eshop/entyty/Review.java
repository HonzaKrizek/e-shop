package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generace automatického klíče
    private Long id;

    @Column
    private String nick;

    @Column(columnDefinition = "text")
    private String evaluation;

    @Column
    private Integer rating;


    @OneToMany(mappedBy = "id")
    private Set<ProductHasReview> productHasReviewSet;
}
