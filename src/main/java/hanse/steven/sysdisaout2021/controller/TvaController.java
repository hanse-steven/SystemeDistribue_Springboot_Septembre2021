package hanse.steven.sysdisaout2021.controller;

import hanse.steven.sysdisaout2021.service.TvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TvaController {

    final TvaService tvaService;

    @Autowired
    public TvaController(TvaService tvaService) {
        this.tvaService = tvaService;
    }

    @GetMapping("/api/tva/{codeTva}")
    public float removeItem(@PathVariable int codeTva){
        return tvaService.getTaux(codeTva);
    }
}
