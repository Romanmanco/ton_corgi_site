package com.ton_corgi_site.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }
}
