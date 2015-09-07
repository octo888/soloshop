package com.rest.controller;

import com.core.beans.Cart;
import com.core.entity.Order;
import com.core.mail.MailMail;
import com.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier(value = "cart")
    private Cart cart;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MailMail mailMail;

    @RequestMapping("/order")
    public String showOrder() {
        return "order";
    }

    @RequestMapping(value = "/add/order", method = RequestMethod.POST)
    public String addOrder(@RequestParam(value = "username") String username,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "phone") String phone,
                           @RequestParam(value = "city") String city,
                           @RequestParam(value = "address") String address)
    {
        Order order = new Order();
        order.setUsername(username);
        order.setEmail(email);
        order.setAddress(address);
        order.setPhone(phone);
        order.setCity(city);
        order.setBooks(cart.getItems());
        order.setOrderSum(cart.totalSum());
        orderService.save(order);

        String msg = "Уважаемый(оя) " + order.getUsername() + "! \n" +
                "Ваш заказ номер " + order.getId() + " принят в обработку. \n" +
                "Сумма заказа: " + order.getOrderSum() + " грн.\n" +
                "В ближайшее время мы свяжемся с Вами для уточнения деталей доставки. \n" +
                "В случае возникновения вопросов, Вы можете связаться с нами по телефону - (093) 381-93-48";

        mailMail.setMailSender(mailSender);
        mailMail.sendMail(order.getEmail(), "Ваш заказ №" + order.getId(), msg);

        cart.clean();
        return "redirect:/order/" + order.getId();
    }

    @RequestMapping("/order/{id}")
    public String orderDetail(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("order", orderService.findOneById(id));
        return "order-detail";
    }
}
