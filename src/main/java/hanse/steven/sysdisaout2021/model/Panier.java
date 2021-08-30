package hanse.steven.sysdisaout2021.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idPanier;

    @Range(min=0,max=1)//0 normal;;1 express
    int typeLivraison = 0;

    @OneToMany(mappedBy="panier",cascade=CascadeType.ALL)
    @JsonManagedReference
    List<PanierItem> panierItems = new ArrayList<>();

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public List<PanierItem> getPanierItems() {
        return panierItems;
    }

    public void setPanierItems(List<PanierItem> panierItems) {
        this.panierItems = panierItems;
    }

    public int getTypeLivraison() {
        return typeLivraison;
    }

    public String getTypeLivraisonString() {
        if (typeLivraison == 0)
            return "Normal";
        return "Express";
    }

    public float getMontantLivraison() {
        if (typeLivraison == 0)
            return 5;
        return 10;
    }

    public void setTypeLivraison(int typeLivraison) {
        this.typeLivraison = typeLivraison;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", typeLivraison=" + typeLivraison +
                ", panierItems=" + panierItems +
                '}';
    }
}
