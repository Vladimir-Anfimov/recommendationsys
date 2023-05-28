package org.recsys.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.infrastucture.entities.Product;
import org.recsys.infrastucture.entities.User;
import org.recsys.repositories.ProductRepository;
import org.recsys.repositories.ProductSpecifications;
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

    private void increaseProductScore(Product product)
    {
        product.setPopularityScore(product.getPopularityScore() + 1);
        productRepository.save(product);
    }

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

    public List<Product> getSearchedProducts(String productName, String category, Double minPrice, Double maxPrice, Double minRating, Double maxRating)
    {
        Specification<Product> specification = ProductSpecifications.searchProducts(productName, category, minPrice, maxPrice, minRating, maxRating);
        List<Product> products = productRepository.findAll(specification);

        if(products.size() > 100)
        {
            return products.subList(0, 100);
        }

        return products;
    }
}
