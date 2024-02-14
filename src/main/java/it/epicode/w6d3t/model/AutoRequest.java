package it.epicode.w6d3t.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AutoRequest {

    private String nome;
    private String marca;
    private int cilindrata;

    private Alimentazione alimentazione;

    private int idPersona;
}
