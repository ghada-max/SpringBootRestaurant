package com.zoch.recipe_sharing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class homeController {

    @GetMapping("/string")
    public String Home() {
        return "Welcome back to code with Zoch";
    }
}
