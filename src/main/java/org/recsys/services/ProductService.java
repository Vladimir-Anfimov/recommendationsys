package org.recsys.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.infrastucture.entities.Product;
import org.recsys.infrastucture.entities.User;
import org.recsys.repositories.ProductRepository;
import org.recsys.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class ProductService
{
    private final UserService userService;
    private final ProductRepository productRepository;

    /**
     * @return the product that has the given id and increases the
     * user-product score and the product score
     */
    public Product getProductById(Integer id, String cookieValue)
    {
        try {
            User user = userService.getUserByCookieSession(cookieValue);

            Product product = productRepository.findProductById(id);

            increaseProductScore(product);

            productRepository.increaseUserProductScore(user.getId(), product.getId(), 1);

            return product;

        } catch (SessionCookieException exception) {
            return null;
        }
    }

    /**
     * This method increases the product popularity
     */
    private void increaseProductScore(Product product)
    {
        product.setPopularityScore(product.getPopularityScore() + 1);
        productRepository.save(product);
    }

    /**
     * @return the list of recommended products
     */
    public List<Product> getRecommendedProducts(String cookieValue)
    {
        try
        {
            User user = userService.getUserByCookieSession(cookieValue);

            return productRepository.getRecommendedProducts(user.getId());

        } catch (SessionCookieException exception)
        {
            return List.of();
        }
    }

    /**
     * @return the list of products that match the given criteria
     */
    public List<Product> getSearchedProducts(String productName, String category, Double minPrice, Double maxPrice, Double minRating, Double maxRating)
    {
        Pageable pageable = PageRequest.of(0, 100);
        Specification<Product> specification = ProductSpecifications.searchProducts(productName, category, minPrice, maxPrice, minRating, maxRating);
        Page<Product> products = productRepository.findAll(specification, pageable);

        return products.getContent();
    }
}
