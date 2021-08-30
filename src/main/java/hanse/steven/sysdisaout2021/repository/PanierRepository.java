package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer> {
    Panier findById(int idPanier);
}
