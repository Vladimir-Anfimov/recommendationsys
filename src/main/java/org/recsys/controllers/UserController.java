package org.recsys.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.recsys.DTOs.SigninRequestDto;
import org.recsys.DTOs.SignupRequestDto;
import org.recsys.exceptions.UserSigninException;
import org.recsys.exceptions.UserSignupException;
import org.recsys.factories.CookieFactory;
import org.recsys.infrastucture.entities.Session;
import org.recsys.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String signin(Model model) {
        return "signin";
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }


    @PostMapping("/signup")
    public String signupPost(@ModelAttribute("signupRequestDto") SignupRequestDto signupRequestDto,
                                     HttpServletResponse response) {
        try {
            Session session = userService.signup(signupRequestDto);
            Cookie sessionCookie = CookieFactory.createSessionCookie(session.getToken());
            response.addCookie(sessionCookie);
            return "redirect:/welcome";

        } catch (UserSignupException exception) {
            return "redirect:/signup?error=" + exception.getMessage();
        }
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute("signinRequestDto") SigninRequestDto signinRequestDto,
                                     HttpServletResponse response) {
        try {
            Session session = userService.signin(signinRequestDto);
            Cookie sessionCookie = CookieFactory.createSessionCookie(session.getToken());
            response.addCookie(sessionCookie);
            return "redirect:/explorer";

        } catch (UserSigninException exception) {
            return "redirect:/signin?error=" + exception.getMessage();
        }
    }
}
