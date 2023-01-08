package dev.tod.petCare.controller;

import dev.tod.petCare.model.dto.AllPetRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class PetController {

    @GetMapping("/pets")
    public ResponseEntity<AllPetRecord> getAllPets(){
        //TODO:
        return null;
    }
}
