package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.repository.OrderRepository;
import hanse.steven.sysdisaout2021.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    CommandeItemService commandeItemService;
    PanierService panierService;
    TvaService tvaService;
    PaiementService paiementService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CommandeItemService commandeItemService, PanierService panierService, TvaService tvaService,PaiementService paiementService) {
        this.orderRepository = orderRepository;
        this.commandeItemService = commandeItemService;
        this.panierService = panierService;
        this.tvaService = tvaService;
        this.paiementService = paiementService;
    }

    public void createOrder(Client client, HttpSession session){
        Object idPanier = session.getAttribute("panier");
        Panier panier = panierService.findById(idPanier,session);

        Commande commande = new Commande();
        float montantTotalCommande = 0;
        commande.setClient(client);
        commande.setTypeLivraison(panier.getTypeLivraison());
        this.save(commande);
        for (PanierItem panierItem : panier.getPanierItems()) {
            CommandeItem commandeItem = new CommandeItem(panierItem.getArticle(),panierItem.getQuantite(),commande);
            commande.getCommandeItems().add(commandeItem);
            commandeItemService.save(commandeItem);
            float montantArticles = panierItem.getMontantTotal();
            float tva = tvaService.getTaux(panierItem.getArticle().getTypeArticle());
            montantTotalCommande += montantArticles + montantArticles*tva;
        }
        commande.setMontant(montantTotalCommande);
        this.save(commande);
        panierService.deletePanier(panier);

        Paiement paiement = new Paiement();
        paiement.setCommande(commande);
        paiement.setClient(client);
        paiementService.save(paiement);
    }

    public void save(Commande commande) {
        orderRepository.save(commande);
    }

    public Commande findById(int idCommande) {
        return orderRepository.findByIdCommande(idCommande);
    }

    public List<Commande>  findOrderByClient(Client client) {
        return orderRepository.findCommandesByClient(client);
    }
}
