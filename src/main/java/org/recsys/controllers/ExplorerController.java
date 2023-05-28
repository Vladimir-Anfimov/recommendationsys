package org.recsys.controllers;

import org.recsys.DTOs.SingleProductDto;
import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.ProductRepository;
import org.recsys.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ExplorerController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/explorer")
    public String explorer(Model model)
    {

        List<Product> recommendedProducts = productRepository.getRecommendedProducts(5);
        model.addAttribute("recommendedProducts", recommendedProducts);

        return "explorer";
    }

    @GetMapping("/explorer/products/{id}")
    public String singleProduct(Model model, @PathVariable Integer id)
    {
        Product product = productService.getProductById(id);
        if(product == null)
        {
            return "redirect:/explorer/products";
        }

        SingleProductDto singleProductDto = new SingleProductDto(product);
        model.addAttribute("product", singleProductDto);
        return "singleproduct";
    }
}
