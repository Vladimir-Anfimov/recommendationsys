package org.recsys.controllers;

import lombok.*;
import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.ProductRepository;
import org.recsys.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RestController
public class SearchController
{
    private final SearchService searchService;
    private final ProductRepository productRepository;

    /*@GetMapping("/search")
    public List<String> getRecommendedProducts()
    {
        return productRepository.getRecommendedProducts(5).stream().map(p->p.getCategory().getName()).toList().stream().distinct().toList();
    }*/

    @GetMapping("/recommended-products")
    public String getRecommendedProducts(Model model) {
        List<Product> recommendedProducts = productRepository.getRecommendedProducts(5);
        model.addAttribute("recommendedProducts", recommendedProducts);

        return "recommended_products";
    }
}
