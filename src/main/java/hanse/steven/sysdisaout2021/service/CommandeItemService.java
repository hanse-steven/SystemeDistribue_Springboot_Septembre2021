package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.repository.CommandeItemRepository;
import hanse.steven.sysdisaout2021.model.CommandeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeItemService {

    CommandeItemRepository commandeItemRepository;

    @Autowired
    public CommandeItemService(CommandeItemRepository commandeItemRepository) {
        this.commandeItemRepository = commandeItemRepository;
    }

    public void save(CommandeItem commandeItem) {
        commandeItemRepository.save(commandeItem);
    }

}
