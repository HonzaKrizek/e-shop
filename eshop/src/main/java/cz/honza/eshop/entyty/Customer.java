package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
//@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private Integer mobileNumber;

    @OneToMany(mappedBy = "id")
    private Set<CustomerHasAddress> customerHasAddresses;

    @OneToMany(mappedBy = "id")
    private Set<OrderHasCustomer> orderHasCustomers;

    /*
    @OneToOne(mappedBy = "customer")
    private User user;

     */


}
