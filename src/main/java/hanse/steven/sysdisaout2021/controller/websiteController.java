package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.loginSystem.CustomUserDetails;
import hanse.steven.sysdisaout2021.model.Panier;
import hanse.steven.sysdisaout2021.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@Controller
public class websiteController {

    final StockService stockService;
    final PanierService panierService;
    final PanierItemService panierItemService;
    final CheckoutService checkoutService;
    final OrderService orderService;

    @Autowired
    public websiteController(StockService stockService, PanierService panierService, PanierItemService panierItemService, CheckoutService checkoutService, OrderService orderService) {
        this.stockService = stockService;
        this.panierService = panierService;
        this.panierItemService = panierItemService;
        this.checkoutService = checkoutService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String getIndex(Model model, HttpSession session) {
        Object idPanier = session.getAttribute("panier");
        panierService.findById(idPanier,session);
        model.addAttribute("articles", stockService.getArticles());
        return "index";
    }

    @GetMapping("/panier")
    public String getCart(Model model, HttpSession session) {
        Object idPanier = session.getAttribute("panier");
        Panier panier = panierService.findById(idPanier,session);
        model.addAttribute("panierItems",panier.getPanierItems());
        model.addAttribute("flag",panier.getTypeLivraison() == 1);
        return "panier";
    }

    @GetMapping("/checkout")
    public String getCheckout(Model model,HttpSession session) {
        model.addAttribute("checkoutmap",checkoutService.doCheckout(session));
        return "checkout";
    }

    @GetMapping("/orders")
    public String getOrders(Model model,@AuthenticationPrincipal CustomUserDetails user) {
        model.addAttribute("commandes",orderService.findOrderByClient(user.getClient()));
        return "orders";
    }

    @GetMapping("/order/{idCommande}")
    public String getOrder(@PathVariable int idCommande,Model model) {
        model.addAttribute("commande",orderService.findById(idCommande));
        return "order";
    }
}
