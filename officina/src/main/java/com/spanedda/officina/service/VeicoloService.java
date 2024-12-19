package com.spanedda.officina.service;


import com.spanedda.officina.entity.Veicolo;
import com.spanedda.officina.repository.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeicoloService {

    @Autowired
    private VeicoloRepository veicoloRepository;

    public List<Veicolo> findAll(){
        return veicoloRepository.findAll();
    }

    public Veicolo save (Veicolo veicolo){
        return veicoloRepository.save(veicolo);
    }
}
