package it.epicode.w6d3t.controller;

import it.epicode.w6d3t.exception.NotFoundException;
import it.epicode.w6d3t.model.Persona;
import it.epicode.w6d3t.model.CustomResponse;
import it.epicode.w6d3t.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/persone")
    public ResponseEntity<CustomResponse> getAll(Pageable pageable){

            return CustomResponse.success(HttpStatus.OK.toString(), personaService.getAll(pageable), HttpStatus.OK);

    }

    @GetMapping("/persone/{id}")
    public ResponseEntity<CustomResponse> getPersonaById(@PathVariable int id){

            return CustomResponse.success(HttpStatus.OK.toString(), personaService.getPersonaById(id), HttpStatus.OK);

    }
    @PostMapping("/persone")
    public ResponseEntity<CustomResponse> savePersona(@RequestBody Persona persona){

            return CustomResponse.success(HttpStatus.OK.toString(), personaService.savePersona(persona), HttpStatus.OK);

    }
    @PutMapping("/persone/{id}")
    public ResponseEntity<CustomResponse> updatePersona(@PathVariable int id, @RequestBody Persona persona){

            return CustomResponse.success(HttpStatus.OK.toString(), personaService.updatePersona(id, persona), HttpStatus.OK);

    }
    @DeleteMapping("/persone/{id}")
    public ResponseEntity<CustomResponse> deletePersona(@PathVariable int id){

            personaService.deletePersona(id);
            return CustomResponse.emptyResponse("Persona con id=" + id + " cancellata", HttpStatus.OK);


    }




}
