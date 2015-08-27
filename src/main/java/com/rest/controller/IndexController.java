package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String indexHome() {
        return "index";
    }

    @RequestMapping("/book")
    public String book() {
        return "book";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
