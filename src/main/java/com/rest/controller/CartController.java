package com.rest.controller;


import com.core.beans.Cart;
import com.core.entity.Book;
import com.core.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class CartController {

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    @Qualifier(value = "cart")
    private Cart cart;

    @Autowired
    private BookService bookService;



    @RequestMapping("/cart")
    public String showCart(Model model) {
        if (cart.getItems() != null) {
            model.addAttribute("items", cart.getItems());
            model.addAttribute("sum", cart.totalSum());
        }
        return "cart";
    }

    @RequestMapping("/{id}/addToCart")
    public String addToCart(@PathVariable Long id) {
        Book book = bookService.findOneById(id);
        if (cart.getItems() == null) {
            List<Book> list = new ArrayList<>();
            list.add(book);
            cart.setItems(list);
        } else {
            List<Book> list = cart.getItems();
            list.add(book);
            cart.setItems(list);
        }
        return "redirect:/";
    }

    @RequestMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable Long id) {
        logger.debug("START remove");
        Book book = bookService.findOneById(id);

        logger.debug("middle remove");

        List<Book> list =  cart.getItems();
        list.remove(book);
        cart.setItems(list);
        logger.debug("END remove");
        return "redirect:/cart";
    }
}
