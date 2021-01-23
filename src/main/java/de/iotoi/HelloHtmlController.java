package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloHtmlController {
    @Value("${web.app.name}")
    String webAppName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("webAppName", webAppName);
        return "home";
    }
}