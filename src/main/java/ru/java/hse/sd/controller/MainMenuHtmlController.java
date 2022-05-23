package ru.java.hse.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuHtmlController {
    @GetMapping("/")
    public String showMainMenu() {
        return "main_menu";
    }
}
