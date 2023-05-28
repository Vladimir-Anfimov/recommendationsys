package org.recsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello, FreeMarker!");
        return "home";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }
}
