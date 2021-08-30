package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.model.Article;
import hanse.steven.sysdisaout2021.model.Paiement;
import hanse.steven.sysdisaout2021.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {

    PaiementRepository paiementRepository;

    @Autowired
    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    public void save(Paiement paiement) {
        paiementRepository.save(paiement);
    }

    public List<Paiement> getPaiements() {
        return paiementRepository.findAll();
    }

    public List<Paiement> getPaiement(int idPaiement) {
        return paiementRepository.findByIdPaiement(idPaiement);
    }

    public List<Paiement> getPaiementByCommande(int idCommande) {
        return paiementRepository.findByCommande_IdCommande(idCommande);
    }

    public List<Paiement> getPaiementByClient(int idClient) {
        return paiementRepository.findByClient_IdClient(idClient);
    }
}
