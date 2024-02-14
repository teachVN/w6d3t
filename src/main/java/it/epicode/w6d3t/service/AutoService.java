package it.epicode.w6d3t.service;

import it.epicode.w6d3t.exception.NotFoundException;
import it.epicode.w6d3t.model.Auto;
import it.epicode.w6d3t.model.AutoRequest;
import it.epicode.w6d3t.model.Persona;
import it.epicode.w6d3t.repository.AutoRepository;
import it.epicode.w6d3t.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private PersonaService personaService;

    public Page<Auto> getAll(Pageable pageable){
        return autoRepository.findAll(pageable);
    }

    public Auto getAutoById(int id) throws NotFoundException {
        return autoRepository.findById(id).orElseThrow(() -> new NotFoundException("Auto con id=" + id + " non trovata"));
    }

    public Auto saveAuto(AutoRequest autoRequest) throws NotFoundException {

        Persona persona = personaService.getPersonaById(autoRequest.getIdPersona());

        Auto auto = new Auto();
        auto.setAlimentazione(autoRequest.getAlimentazione());
        auto.setNome(autoRequest.getNome());
        auto.setCilindrata(autoRequest.getCilindrata());
        auto.setMarca(autoRequest.getMarca());
        auto.setPersona(persona);

        return autoRepository.save(auto);

    }

    public Auto updateAuto(int id, AutoRequest autoRequest) throws NotFoundException {
        Auto auto = getAutoById(id);

        Persona persona = personaService.getPersonaById(autoRequest.getIdPersona());

        auto.setAlimentazione(autoRequest.getAlimentazione());
        auto.setNome(autoRequest.getNome());
        auto.setCilindrata(autoRequest.getCilindrata());
        auto.setMarca(autoRequest.getMarca());
        auto.setPersona(persona);

        return autoRepository.save(auto);

    }

    public void deleteAuto(int id) throws NotFoundException {
        Auto auto = getAutoById(id);

        autoRepository.delete(auto);
    }
}
