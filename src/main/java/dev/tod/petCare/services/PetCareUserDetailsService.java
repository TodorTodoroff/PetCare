package dev.tod.petCare.services;


import dev.tod.petCare.model.entities.UserEntity;
import dev.tod.petCare.model.user.PetCareUserDetails;
import dev.tod.petCare.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class PetCareUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public PetCareUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username)
                .map(this::map)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "User with email " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new PetCareUserDetails(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUserRoles()
        );
    }




}


