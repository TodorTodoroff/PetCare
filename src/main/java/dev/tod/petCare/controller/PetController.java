package dev.tod.petCare.controller;

import dev.tod.petCare.model.dto.DashboardPet;
import dev.tod.petCare.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<DashboardPet>> getAllPets() {
        return ResponseEntity
                .ok(this.petService.findDashboardPets());
    }
}
