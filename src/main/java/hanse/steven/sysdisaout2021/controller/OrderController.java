package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.loginSystem.CustomUserDetails;
import hanse.steven.sysdisaout2021.model.Commande;
import hanse.steven.sysdisaout2021.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@RestController
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/order")
    public RedirectView createOrder(@AuthenticationPrincipal CustomUserDetails user, HttpSession session) {
        orderService.createOrder(user.getClient(),session);
        return new RedirectView("/orders");
    }

    @GetMapping("/api/order/{idCommande}")
    public Commande getOrderById(@PathVariable int idCommande) {
        return orderService.findById(idCommande);
    }
}
