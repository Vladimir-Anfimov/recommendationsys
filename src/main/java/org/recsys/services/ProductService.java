package org.recsys.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class ProductService
{
    private final ProductRepository productRepository;

    public Product getProductById(Integer id)
    {
        Product product = productRepository.findProductById(id);
//        increaseProductScore(product); TO DO
        return product;
    }

    private void increaseProductScore(Product product)
    {
        product.setPopularityScore(product.getPopularityScore() + 1);
        productRepository.save(product);
    }
}
