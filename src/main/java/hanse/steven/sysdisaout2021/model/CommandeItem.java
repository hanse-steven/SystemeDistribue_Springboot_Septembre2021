package hanse.steven.sysdisaout2021.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class CommandeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCommandeItem;

    @Min(value=0)
    int quantite;

    @NotNull
    @ManyToOne
    Article article;

    @NotNull
    @ManyToOne
    @JoinColumn(name="idCommande")
    @JsonBackReference
    Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public CommandeItem() {
    }

    public CommandeItem(Article article, int quantite, Commande commande) {
        this.quantite = quantite;
        this.article = article;
        this.commande = commande;
    }

    public int getIdCommandeItem() {
        return idCommandeItem;
    }

    public void setIdCommandeItem(int idCommandeItem) {
        this.idCommandeItem = idCommandeItem;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "CommandeItem{" +
                "idCommandeItem=" + idCommandeItem +
                ", quantite=" + quantite +
                ", article=" + article +
                '}';
    }
}
