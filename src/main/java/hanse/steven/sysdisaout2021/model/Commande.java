package hanse.steven.sysdisaout2021.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {

    public final static int EN_PREPARATION = 1;
    public final static int EXPEDIEE = 2;
    public final static int RECEPTIONNEE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCommande;

    @Min(value=0)
    float montant;

    @Range(min=0,max=1)//0 normal;;1 express
    int typeLivraison = 0;

    @Range(min=EN_PREPARATION,max=RECEPTIONNEE)
    int status = EN_PREPARATION;

    @ManyToOne
    @JoinColumn(name="idClient")
    Client client;

    @OneToMany(targetEntity=CommandeItem.class, mappedBy="commande")
    @JsonManagedReference
    List<CommandeItem> commandeItems = new ArrayList<>();

    public Commande() {
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getTypeLivraison() {
        return typeLivraison;
    }

    public void setTypeLivraison(int typeLivraison) {
        this.typeLivraison = typeLivraison;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    public String getTypeLivraisonString() {
        if (typeLivraison == 0)
            return "Normal";
        return "Express";
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", montant=" + montant +
                ", typeLivraison=" + typeLivraison +
                ", status=" + status +
                ", client=" + client +
                ", commandeItems=" + commandeItems +
                '}';
    }
}
