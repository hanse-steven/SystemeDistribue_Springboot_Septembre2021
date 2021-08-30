package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.model.Panier;
import hanse.steven.sysdisaout2021.model.PanierItem;
import hanse.steven.sysdisaout2021.service.PanierItemService;
import hanse.steven.sysdisaout2021.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@RestController
public class CartController {

    final PanierService panierService;
    final PanierItemService panierItemService;

    @Autowired
    public CartController(PanierService panierService, PanierItemService panierItemService) {
        this.panierService = panierService;
        this.panierItemService = panierItemService;
    }

    @GetMapping("/api/cart")
    public Panier getCart(HttpSession session) {
        Object idPanier = session.getAttribute("panier");
        return panierService.findById(idPanier,session);
    }

    @PostMapping("/api/livraison/")
    public RedirectView setLivraison(@RequestParam("livraison") int value, HttpSession session){
        Object idPanier = session.getAttribute("panier");
        Panier panier = panierService.findById(idPanier,session);
        panier.setTypeLivraison(value);
        return new RedirectView("/panier");
    }

    @PostMapping("/api/addItem")
    public RedirectView addItem(PanierItem panierItem, HttpSession session) {
        panierService.addItem(panierItem,session);
        return new RedirectView("/panier");
    }

    @GetMapping("/api/removeItem/{id}")
    public RedirectView removeItem(@PathVariable int id){
        panierService.removeItem(id);
        return new RedirectView("/panier");
    }




}
