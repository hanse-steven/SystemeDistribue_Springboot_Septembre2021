package hanse.steven.sysdisaout2021.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class PanierItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idPanierItem;

    @Min(value=0)
    int quantite;

    @NotNull
    @ManyToOne
    @JoinColumn(name="idArticle")
    Article article;

    @NotNull
    @ManyToOne
    @JoinColumn(name="idPanier")
    @JsonBackReference
    Panier panier;

    public PanierItem() {}

    public PanierItem(Panier panier,Article article,int quantite) {
        this.panier = panier;
        this.article = article;
        this.quantite = quantite;
    }

    public int getQuantite() { return quantite; }

    public void setQuantite(int quantite) { this.quantite = quantite; }

    public Article getArticle() { return article; }

    public void setArticle(Article article) { this.article = article; }

    public Panier getPanier() { return panier; }

    public void setPanier(Panier panier) { this.panier = panier; }

    public int getIdPanierItem() {
        return idPanierItem;
    }

    public void setIdPanierItem(int idPanierItem) {
        this.idPanierItem = idPanierItem;
    }

    public float getMontantTotal() {
        return getQuantite() * getArticle().getPrix();
    }

    @Override
    public String toString() {
        return "PanierItem{" +
                "quantite=" + quantite +
                ", article=" + article +
                ", panier=" + panier +
                '}';
    }
}
