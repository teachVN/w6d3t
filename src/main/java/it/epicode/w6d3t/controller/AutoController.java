package it.epicode.w6d3t.controller;

import it.epicode.w6d3t.exception.NotFoundException;
import it.epicode.w6d3t.model.Auto;
import it.epicode.w6d3t.model.AutoRequest;
import it.epicode.w6d3t.model.CustomResponse;
import it.epicode.w6d3t.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutoController {
    @Autowired
    private AutoService autoService;
    @GetMapping("/auto")
    public ResponseEntity<CustomResponse> getAll(Pageable pageable){
        try {
            return CustomResponse.success(HttpStatus.OK.toString(), autoService.getAll(pageable), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/auto/{id}")
    public ResponseEntity<CustomResponse> getAutoById(@PathVariable int id){
        try {
            return CustomResponse.success(HttpStatus.OK.toString(), autoService.getAutoById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/auto")
    public ResponseEntity<CustomResponse> saveAuto(@RequestBody AutoRequest autoRequest){
        try{
            return CustomResponse.success(HttpStatus.OK.toString(), autoService.saveAuto(autoRequest), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/auto/{id}")
    public ResponseEntity<CustomResponse> updateAuto(@PathVariable int id, @RequestBody AutoRequest autoRequest){
        try {
            return CustomResponse.success(HttpStatus.OK.toString(), autoService.updateAuto(id, autoRequest), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/auto/{id}")
    public ResponseEntity<CustomResponse> deleteAuto(@PathVariable int id){
        try {
            autoService.deleteAuto(id);
            return CustomResponse.emptyResponse("Auto con id=" + id + " cancellata", HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
