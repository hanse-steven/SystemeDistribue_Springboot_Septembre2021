package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.model.Panier;
import hanse.steven.sysdisaout2021.model.PanierItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class CheckoutService {

    PanierService panierService;
    TvaService tvaService;

    @Autowired
    public CheckoutService(TvaService tvaService,PanierService panierService) {
        this.tvaService = tvaService;
        this.panierService = panierService;
    }

    public HashMap<String, Float> doCheckout(HttpSession session){
        Object idPanier = session.getAttribute("panier");
        Panier panier = panierService.findById(idPanier,session);

        HashMap<String,Float> totalPanier = new HashMap<>();
        for (PanierItem panierItem : panier.getPanierItems()) {
            float montantArticles = panierItem.getMontantTotal();
            float tva = tvaService.getTaux(panierItem.getArticle().getTypeArticle());
            float totalMontantArticle = montantArticles + montantArticles*tva;
            totalPanier.put(panierItem.getQuantite() + " x " + panierItem.getArticle().getNom(),totalMontantArticle);
        }
        totalPanier.put("Livraison " + panier.getTypeLivraisonString(),panier.getMontantLivraison());
        return totalPanier;
    }
}
