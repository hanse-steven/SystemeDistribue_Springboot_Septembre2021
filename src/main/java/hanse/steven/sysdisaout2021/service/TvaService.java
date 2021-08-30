package hanse.steven.sysdisaout2021.service;

import hanse.steven.sysdisaout2021.repository.TvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvaService {

    final TvaRepository tvaRepository;

    @Autowired
    public TvaService(TvaRepository tvaRepository) {
        this.tvaRepository = tvaRepository;
    }

    public float getTaux(int codeTva) {
        return tvaRepository.findByIdTva(codeTva).getTaux();
    }
}
