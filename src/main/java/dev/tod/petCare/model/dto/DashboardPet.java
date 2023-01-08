package dev.tod.petCare.model.dto;

import java.util.UUID;

public record DashboardPet(String image, String name, String breed, UUID _id) {
}
