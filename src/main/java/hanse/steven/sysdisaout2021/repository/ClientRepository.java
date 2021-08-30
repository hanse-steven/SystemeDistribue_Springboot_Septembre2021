package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByNom(String nom);
}
