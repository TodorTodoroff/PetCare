package dev.tod.petCare.services;

import dev.tod.petCare.model.auth.LoginRequest;
import dev.tod.petCare.model.auth.LoginResponse;
import dev.tod.petCare.model.auth.RegisterRequest;
import dev.tod.petCare.model.auth.RegisterResponse;
import dev.tod.petCare.model.entities.UserEntity;
import dev.tod.petCare.model.enums.UserRoleEnum;
import dev.tod.petCare.model.user.PetCareUserDetails;
import dev.tod.petCare.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager,
            TokenService tokenService,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {

        PetCareUserDetails petCareUserDetails =
                (PetCareUserDetails) this.userDetailsService
                .loadUserByUsername(request.email());

        Authentication authentication = authenticateRequest(
                request.email(),
                request.password());

        return new LoginResponse(
                petCareUserDetails.getId(),
                petCareUserDetails.getUsername(),
                generateJwtToken(authentication)
        );
    }



    public RegisterResponse register(RegisterRequest request) {

        UserEntity user = UserEntity.builder()
                .email(request.email())
                .firstName("Pencho")
                .lastName("Penev")
                .password(passwordEncoder.encode(request.password()))
                .isActive(true)
                .userRoles(UserRoleEnum.USER)
                .build();

        this.userRepository.save(user);

        Authentication authentication = authenticateRequest(request.email(), request.password());

        return new RegisterResponse(
                user.getId(),
                user.getEmail(),
                generateJwtToken(authentication)
        );
    }

    private String generateJwtToken(Authentication authentication){
        return this.tokenService.generateToken(authentication);
    }

    private Authentication authenticateRequest(String email, String password) {
        Authentication authenticate = this.authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                email,
                                password));

        SecurityContextHolder.
                getContext().
                setAuthentication(authenticate);

        return authenticate;
    }
}
