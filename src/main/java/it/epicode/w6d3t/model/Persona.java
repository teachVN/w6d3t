package it.epicode.w6d3t.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cognome;
    private String indirizzo;
    private LocalDate dataNascita;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Auto> auto;
}
