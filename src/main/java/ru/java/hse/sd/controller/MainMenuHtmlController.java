package ru.java.hse.sd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class that responds to main menu. Works with HTML.
 **/
@Controller
public class MainMenuHtmlController {
    /**
     * Returns main menu.
     *
     * @return page with main menu
     **/
    @GetMapping("/")
    public String showMainMenu() {
        return "main_menu";
    }
}
