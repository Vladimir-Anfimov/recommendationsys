package org.recsys.repositories;

import org.recsys.infrastucture.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

/**
 * Interface that has methods that make queries and calls in the db
 */
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>
{
    /**
     * This query uses the get_complete_recommended_products function from the db to retrieve the recommended products
     */
    @Query(value = "select * from get_complete_recommended_products(:user_id, 50);", nativeQuery = true)
    List<Product> getRecommendedProducts(Integer user_id);

    Product findProductById(Integer id);

    /**
     * This procedure increases the user-product score
     */
    @Procedure(value = "incr_user_product_score")
    void increaseUserProductScore(Integer user_id, Integer product_id, Integer inc);
}
