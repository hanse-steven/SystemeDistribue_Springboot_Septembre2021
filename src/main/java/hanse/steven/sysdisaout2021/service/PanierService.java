package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.repository.PanierRepository;
import hanse.steven.sysdisaout2021.model.Panier;
import hanse.steven.sysdisaout2021.model.PanierItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PanierService {

    final PanierRepository panierRepository;
    final PanierItemService panierItemService;

    @Autowired
    public PanierService(PanierRepository panierRepository, PanierItemService panierItemService) {
        this.panierRepository = panierRepository;
        this.panierItemService = panierItemService;
    }

    public Panier findById(Object idPanier, HttpSession session) {
        Panier panier;
        if (idPanier != null) {//Si un id de panier est connu de la session
            panier = panierRepository.findById((int)idPanier);
            if (panier != null) return panier;
        }
        panier = new Panier();
        this.save(panier);
        session.setAttribute("panier",panier.getIdPanier());
        return panier;
    }

    public void addItem(PanierItem panierItem, HttpSession session) {
        Object idPanier = session.getAttribute("panier");
        Panier panier = this.findById(idPanier,session);
        panierItem.setPanier(panier);
        panierItemService.save(panierItem);
    }

    public void removeItem(int idPanierItem) {
        panierItemService.removeItem(idPanierItem);
    }

    public void deletePanier(Panier panier) {
        panierRepository.delete(panier);
    }

    public void save(Panier panier) {
        panierRepository.save(panier);
    }



}
