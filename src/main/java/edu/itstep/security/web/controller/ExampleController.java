package edu.itstep.security.web.controller;

import edu.itstep.security.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
@Tag(name = "Examples", description = "Examples of request with different roles")
public class ExampleController {
    private final UserService service;

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    @Operation(summary = "Only for authenticated users")
    public String example() {
        return "Hello, world!";
    }

    @Operation(summary = "Only for admins")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Hello, admin!";
    }


    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/get-admin")
    @Operation(summary = "Get admin role")
    public void getAdmin() {
        service.getAdmin();
    }
}