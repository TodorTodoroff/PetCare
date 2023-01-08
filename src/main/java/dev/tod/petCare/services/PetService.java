package dev.tod.petCare.services;

import dev.tod.petCare.model.dto.AllPetRecord;
import dev.tod.petCare.model.dto.DashboardPet;
import dev.tod.petCare.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public AllPetRecord findDashboardPets() {
        List<DashboardPet> collect = this.petRepository
                .findAll()
                .stream()
                .map(pet ->
                        new DashboardPet(
                                pet.getImage(),
                                pet.getName(),
                                pet.getBreed(),
                                pet.getId())
                )
                .toList();
        return new AllPetRecord(collect);
    }
}
