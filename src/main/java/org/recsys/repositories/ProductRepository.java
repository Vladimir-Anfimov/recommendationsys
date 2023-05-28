package org.recsys.repositories;

import org.recsys.infrastucture.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    @Query(value = "select * from get_complete_recommended_products(:user_id, 50);", nativeQuery = true)
    List<Product> getRecommendedProducts(Integer user_id);

    Product findProductById(Integer id);

    @Procedure(value = "incr_user_product_score")
    void increaseUserProductScore(Integer user_id, Integer product_id, Integer inc);
}
