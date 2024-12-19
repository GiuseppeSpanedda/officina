package com.spanedda.officina.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veicolo_seq")
    @SequenceGenerator(name = "veicolo_seq", sequenceName = "veicolo_sequence", allocationSize = 1)
    private Long id;
    private String tipo;
    private String modello;
}
