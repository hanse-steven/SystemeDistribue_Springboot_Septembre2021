package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Client;
import hanse.steven.sysdisaout2021.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Commande, Integer> {
    Commande findByIdCommande(int idCommande);
    List<Commande> findCommandesByClient(Client client);
}
