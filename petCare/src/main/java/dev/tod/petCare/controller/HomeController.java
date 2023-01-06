package dev.tod.petCare.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("/read")
    public String read() {
        return "This is SCOPE_read!";
    }

    @PreAuthorize("hasAuthority('SCOPE_write')")
    @GetMapping("/write")
    public String write() {
        return "This is SCOPE_write!";
    }
}
