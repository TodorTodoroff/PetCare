package dev.tod.petCare.repository;

import dev.tod.petCare.model.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, UUID> {
}
