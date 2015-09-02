package com.rest.controller;

import com.core.beans.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@Scope("session")
public class GlobalController {

    @Autowired
    @Qualifier(value = "cart")
    private Cart cart;

    @ModelAttribute
    public void globalAttributes(Model model) {
        if (cart.getItems() == null) {
            model.addAttribute("cartItemsNum", 0 + "");
        } else {
            model.addAttribute("cartItemsNum", cart.getItems().size() + "");
        }

    }
}
