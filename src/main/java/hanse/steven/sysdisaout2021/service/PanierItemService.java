package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.repository.PanierItemRepository;
import hanse.steven.sysdisaout2021.model.PanierItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PanierItemService {

    final PanierItemRepository panierItemRepository;

    @Autowired
    public PanierItemService(PanierItemRepository panierItemRepository) {
        this.panierItemRepository = panierItemRepository;
    }

    public void save(PanierItem panierItem) {
        panierItemRepository.save(panierItem);
    }

    @Transactional
    public void removeItem(int idPanierItem) {
        panierItemRepository.deleteByIdPanierItem(idPanierItem);
    }
}
