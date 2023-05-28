package org.recsys.repositories;

import jakarta.persistence.criteria.Predicate;
import org.recsys.infrastucture.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecifications {

    public static Specification<Product> searchProducts(String productName, String category, Double minPrice,
                                                        Double maxPrice, Double minRating, Double maxRating) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (productName != null && !productName.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + productName.toLowerCase() + "%"));
            }
//            if (category != null && !category.isEmpty()) {
//                predicates.add(cb.equal(root.get("category").get("id"), Integer.valueOf(category)));
//            }
            if (minPrice != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("actualPrice"), minPrice));
            }
            if (maxPrice != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("actualPrice"), maxPrice));
            }
            if (minRating != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("ratings"), minRating));
            }
            if (maxRating != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("ratings"), maxRating));
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}