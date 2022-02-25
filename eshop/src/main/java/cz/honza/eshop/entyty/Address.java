package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private String zip;

    @Column
    private String country;

    @OneToMany(mappedBy = "id")
    private Set<CustomerHasAddress> customerHasAddresses;


}
