package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Adress {

    @Id
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String zip;

    @Column
    private String country;
}
