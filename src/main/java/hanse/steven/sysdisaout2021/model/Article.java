package hanse.steven.sysdisaout2021.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idArticle;

    @NotNull
    String nom;

    @Min(value=1)
    float prix;

    @Min(value=0)
    int quantiteDisponible;

    @NotNull
    int typeArticle;

    public Article() {}

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public int getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(int typeArticle) {
        this.typeArticle = typeArticle;
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantiteDisponible=" + quantiteDisponible +
                ", typeArticle=" + typeArticle +
                '}';
    }
}
