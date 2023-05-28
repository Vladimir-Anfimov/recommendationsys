package org.recsys.controllers;

import org.recsys.DTOs.AddToWishlistDto;
import org.recsys.DTOs.SignupRequestDto;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishlistController {
    private final UserService userService;

    public WishlistController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/wishlist/add/{productId}")
    public String addToWishlist(
            @CookieValue(value = "token", defaultValue = "NONE") String cookieValue,
            Model model,
            @PathVariable Integer productId)
    {
        try {
            userService.addWishlistItem(cookieValue, productId);
        } catch (SessionCookieException exception) {
            return "redirect:/signin";
        }
        return "redirect:/wishlist";
    }

    @GetMapping("/wishlist")
    public String wishlist(
            @CookieValue(value = "token", defaultValue = "NONE") String cookieValue,
            Model model)
    {
        try {
            model.addAttribute("wishlist", userService.getWishlist(cookieValue));
        } catch (SessionCookieException exception) {
            return "redirect:/signin";
        }
        return "wishlist";
    }
}
