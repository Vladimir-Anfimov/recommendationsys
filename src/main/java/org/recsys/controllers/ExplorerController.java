package org.recsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExplorerController {

    @GetMapping("/explorer")
    public String explorer(Model model) {
        return "explorer";
    }
}
