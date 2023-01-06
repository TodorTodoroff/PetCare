package dev.tod.petCare.repository;

import dev.tod.petCare.model.entities.UserRoleEntity;
import dev.tod.petCare.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByUserRole(UserRoleEnum admin);
}
