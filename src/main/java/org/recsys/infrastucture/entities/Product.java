package org.recsys.infrastucture.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String image;

    private String link;

    private Double ratings;

    private Integer numberOfRatings;

    private Double discountPrice;

    private Double actualPrice;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "wishlist")
    private List<User> users;
}
