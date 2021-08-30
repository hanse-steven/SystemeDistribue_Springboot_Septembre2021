package hanse.steven.sysdisaout2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idClient;

    @NotEmpty
    String nom;

    @NotEmpty
    String password;

    @NotEmpty
    String adresse;

    @Min(value=0)
    float soldeCompte;

    public Client() {}

    public int getIdClient() { return idClient; }

    public void setIdClient(int idClient) { this.idClient = idClient; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() { return adresse; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public float getSoldeCompte() { return soldeCompte; }

    public void setSoldeCompte(float soldeCompte) { this.soldeCompte = soldeCompte; }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                ", adresse='" + adresse + '\'' +
                ", soldeCompte=" + soldeCompte +
                '}';
    }
}
