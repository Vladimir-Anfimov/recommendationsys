package org.recsys.repositories;

import org.recsys.infrastucture.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    @Query(value = "select * from get_complete_recommended_products(:user_id, 50);", nativeQuery = true)
    List<Product> getRecommendedProducts(Integer user_id);

    Product findProductById(Integer id);
}
