package org.recsys.controllers;

import org.recsys.DTOs.AddToWishlistDto;
import org.recsys.DTOs.SignupRequestDto;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for wishlist endpoint
 */
@Controller
public class WishlistController {
    private final UserService userService;

    public WishlistController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Post method to add a product to a wishlist
     * @param cookieValue the cookie used for extracting the userId
     */
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

    /**
     * Post method to remove a product from a wishlist
     * @param cookieValue the cookie used for extracting the userId
     */
    @PostMapping("/wishlist/remove/{productId}")
    public String removeFromWishlist(
            @CookieValue(value = "token", defaultValue = "NONE") String cookieValue,
            Model model,
            @PathVariable Integer productId)
    {
        try {
            userService.removeWishlistItem(cookieValue, productId);
        } catch (SessionCookieException exception) {
            return "redirect:/signin";
        }
        return "redirect:/wishlist";
    }

    /**
     * Get method for getting all the products from a wishlist
     */
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
