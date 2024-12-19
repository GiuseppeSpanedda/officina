package com.spanedda.officina.controller;

import com.spanedda.officina.entity.Veicolo;
import com.spanedda.officina.service.VeicoloService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/veicolo")
public class VeicoloController {

    private final VeicoloService veicoloService;

    public VeicoloController(VeicoloService veicoloService) {
        this.veicoloService = veicoloService;
    }

    @PostMapping("/create")
    public Veicolo createVeicolo(@RequestBody Veicolo veicolo) {
        return veicoloService.save(veicolo);
    }

    @GetMapping("/all")
    public List<Veicolo> getAllVeicoli (){
        return veicoloService.findAll();
    }

    @GetMapping("/get/{idVeicolo}")
    public Veicolo getVeicolo(@PathVariable Long idVeicolo) {
        return veicoloService.findById(idVeicolo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veicolo non trovato"));
    }

    @PutMapping("/update/{idVeicolo}")
    public Veicolo updateVeicolo(@PathVariable Long idVeicolo, @RequestBody Veicolo veicoloDetails) {
        Veicolo veicolo = veicoloService.findById(idVeicolo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veicolo non trovato"));

        veicolo.setTipo(veicoloDetails.getTipo());
        veicolo.setModello(veicoloDetails.getModello());
        veicolo.setTarga(veicoloDetails.getTarga());

        return veicoloService.save(veicolo);
    }

    @DeleteMapping("/delete/{idVeicolo}")
    public Veicolo deleteVeicolo(@PathVariable Long idVeicolo) {
        Veicolo veicolo = veicoloService.findById(idVeicolo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veicolo non trovato"));

        veicoloService.delete(veicolo);
        return veicolo;
    }


}
