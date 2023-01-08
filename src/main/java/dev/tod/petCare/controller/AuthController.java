package dev.tod.petCare.controller;

import dev.tod.petCare.model.auth.LoginResponse;
import dev.tod.petCare.model.auth.LoginRequest;
import dev.tod.petCare.model.auth.RegisterRequest;
import dev.tod.petCare.model.auth.RegisterResponse;
import dev.tod.petCare.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest
    ) throws AuthenticationException {
        LOG.info("User: " + loginRequest.email() + " logged!");
        return ResponseEntity
                .ok(this.userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) throws AuthenticationException{
        LOG.info("User: " + registerRequest.email() + " registered!");
        return ResponseEntity
                .ok(this.userService.register(registerRequest));
    }


}

