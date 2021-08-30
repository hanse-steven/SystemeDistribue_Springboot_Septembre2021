package hanse.steven.sysdisaout2021.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idTva;

    @Range(min=0) //en théorie, une tva peut même être de 1000%
    float taux;

    public Tva() {}

    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Tva{" +
                "id=" + idTva +
                ", taux=" + taux +
                '}';
    }
}
