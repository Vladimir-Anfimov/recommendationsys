package org.recsys.controllers;

import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExplorerController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/explorer")
    public String explorer(Model model)
    {

        List<Product> recommendedProducts = productRepository.getRecommendedProducts(5);
        model.addAttribute("recommendedProducts", recommendedProducts);

        return "explorer";
    }
}
