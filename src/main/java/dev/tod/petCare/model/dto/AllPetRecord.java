package dev.tod.petCare.model.dto;

import dev.tod.petCare.model.entities.PetEntity;

import java.util.List;

public record AllPetRecord(List<PetEntity> pets) {
}
