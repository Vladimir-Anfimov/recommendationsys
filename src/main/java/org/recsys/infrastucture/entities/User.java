package org.recsys.infrastucture.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "rec_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String hashedPassword;

    @ManyToMany
    @JoinTable(
            name = "wishlists",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> wishlist;
}
