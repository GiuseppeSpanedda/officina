package com.spanedda.officina.controller;

import com.spanedda.officina.entity.Veicolo;
import com.spanedda.officina.service.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

    @Autowired
    private VeicoloService veicoloService;

    @GetMapping("/all")
    public List<Veicolo> getAllVeicoli (){
        return veicoloService.findAll();
    }

    @PostMapping("/create")
    public Veicolo createVeicolo(@RequestBody Veicolo veicolo) {
        return veicoloService.save(veicolo);
    }
}
