package hanse.steven.sysdisaout2021.repository;

import hanse.steven.sysdisaout2021.model.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvaRepository extends JpaRepository<Tva,Integer> {
    Tva findByIdTva(int codeTva);
}
