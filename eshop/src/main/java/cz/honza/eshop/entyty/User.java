package cz.honza.eshop.entyty;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nick;

    @Column
    private String hashPassword;

    @Column
    private Boolean administrator;

    /*
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

     */
}
