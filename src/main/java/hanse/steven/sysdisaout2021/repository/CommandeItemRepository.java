package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem, Integer> {
}
