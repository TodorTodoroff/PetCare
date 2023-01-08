package dev.tod.petCare.services;

import dev.tod.petCare.model.auth.LoginRequest;
import dev.tod.petCare.model.auth.LoginResponse;
import dev.tod.petCare.model.user.PetCareUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public UserService(
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager,
            TokenService tokenService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public LoginResponse login(LoginRequest request) {
        var userDetails =
                (PetCareUserDetails) userDetailsService.loadUserByUsername(request.email());

        Authentication authenticate = this.authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()));

        SecurityContextHolder.
                getContext().
                setAuthentication(authenticate);

        String token = this.tokenService.generateToken(authenticate);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setEmail(userDetails.getUsername());
        loginResponse.setAccessToken(token);
        loginResponse.set_id(userDetails.getId());

        return loginResponse;
    }


}
