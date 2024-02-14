package it.epicode.w6d3t.service;

import it.epicode.w6d3t.exception.NotFoundException;
import it.epicode.w6d3t.model.Persona;
import it.epicode.w6d3t.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Page<Persona> getAll(Pageable pageable){
        return personaRepository.findAll(pageable);
    }

    public Persona getPersonaById(int id) throws NotFoundException{
        return personaRepository.findById(id).orElseThrow(()->new NotFoundException("Persona con id=" + id + " non trovata"));
    }

    public Persona savePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Persona updatePersona(int id, Persona persona) throws NotFoundException {
        Persona p = getPersonaById(id);

        p.setNome(persona.getNome());
        p.setCognome(persona.getCognome());
        p.setIndirizzo(persona.getIndirizzo());
        p.setDataNascita(persona.getDataNascita());

        return personaRepository.save(p);
    }

    public void deletePersona(int id) throws NotFoundException {
        Persona persona = getPersonaById(id);
        personaRepository.delete(persona);
    }
}
