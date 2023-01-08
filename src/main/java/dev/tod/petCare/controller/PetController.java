package dev.tod.petCare.controller;

import dev.tod.petCare.model.dto.AllPetRecord;
import dev.tod.petCare.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity<AllPetRecord> getAllPets() {
        return ResponseEntity
                .ok(this.petService.findDashboardPets());
    }
}
