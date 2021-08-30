package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Integer> {
    List<Paiement> findByIdPaiement(int idPaiement);
    //List<Paiement> findByIdCommande(int idCommande);
    //List<Paiement> findByIdClient(int idClient);
    List<Paiement> findByClient_IdClient(int idClient);
    List<Paiement> findByCommande_IdCommande(int idCommande);
}
