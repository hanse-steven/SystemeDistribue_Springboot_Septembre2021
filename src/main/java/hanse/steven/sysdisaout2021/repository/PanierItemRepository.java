package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.PanierItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierItemRepository extends JpaRepository<PanierItem, Integer> {
    void deleteByIdPanierItem(int idPanierItem);
}
