package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.model.Article;
import hanse.steven.sysdisaout2021.model.Paiement;
import hanse.steven.sysdisaout2021.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaiementController {

    PaiementService paiementService;

    @Autowired
    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping("/api/paiement/all")
    public List<Paiement> ListingPaiement() {
        return paiementService.getPaiements();
    }

    @GetMapping("/api/paiement/paiement/{idPaiement}")
    public List<Paiement> ListingArticleParId(@PathVariable int idPaiement) {
        return paiementService.getPaiement(idPaiement);
    }

    @GetMapping("/api/paiement/commande/{idCommande}")
    public List<Paiement> ListingPaiementParCommande(@PathVariable int idCommande) {
        return paiementService.getPaiementByCommande(idCommande);
    }

    @GetMapping("/api/paiement/client/{idClient}")
    public List<Paiement> ListingPaiementParClient(@PathVariable int idClient) {
        return paiementService.getPaiementByClient(idClient);
    }
}
