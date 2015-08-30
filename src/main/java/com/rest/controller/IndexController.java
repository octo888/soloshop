package com.rest.controller;

import com.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String indexHome(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
