package org.recsys.controllers;

import org.recsys.DTOs.SingleProductDto;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.infrastucture.entities.Category;
import org.recsys.infrastucture.entities.Product;
import org.recsys.infrastucture.entities.User;
import org.recsys.repositories.CategoryRepository;
import org.recsys.repositories.ProductRepository;
import org.recsys.services.ProductService;
import org.recsys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ExplorerController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/explorer")
    public String explorer(@CookieValue(value = "token", defaultValue = "NONE") String cookieValue, Model model)
    {

        List<SingleProductDto> recommendedProducts = productService.getRecommendedProducts(cookieValue).stream().map(SingleProductDto::new).toList();
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("recommendedProducts", recommendedProducts);

        return "explorer";
    }

    @GetMapping("/explorer/products/{id}")
    public String singleProduct(@CookieValue(value = "token", defaultValue = "NONE") String cookieValue,
                                Model model,
                                @PathVariable Integer id)
    {
        Product product = productService.getProductById(id, cookieValue);

        if(product == null)
        {
            return "redirect:/explorer/products";
        }

        SingleProductDto singleProductDto = new SingleProductDto(product);
        model.addAttribute("product", singleProductDto);

        return "singleproduct";
    }
}
