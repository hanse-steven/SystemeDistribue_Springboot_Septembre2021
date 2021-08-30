package hanse.steven.sysdisaout2021.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idPaiement;

    @NotNull
    @ManyToOne
    @JoinColumn(name="idClient")
    Client client;

    @NotNull
    @ManyToOne
    @JoinColumn(name="idCommande")
    Commande commande;

    public Paiement() {
    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "idPaiement=" + idPaiement +
                ", client=" + client +
                ", commande=" + commande +
                '}';
    }
}
