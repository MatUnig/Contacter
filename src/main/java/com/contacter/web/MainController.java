package com.contacter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/403")
    public String unauthorized() {
        return "403";
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
