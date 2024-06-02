package edu.itstep.security.web.controller;

import edu.itstep.security.domain.model.Product;
import edu.itstep.security.domain.model.User;
import edu.itstep.security.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Authentication getMe(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/{id:\\d+}")
    public Principal getMe(Principal user) {
        System.out.println(user);
        return user;
    }

    @GetMapping("/secret")
    @PreAuthorize("@customSecurityService.isNorm(authentication.principal.id)")
    public String secretPath() {
        return "Norm! :)";
    }

    @GetMapping("/get-me/{id:\\d+}")
    @PostAuthorize("hasRole('ADMIN') or authentication.principal.id == returnObject.id")
    public User getMeSecure(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    @PostFilter("filterObject.owner.id == authentication.principal.id")
    public List<Product> getProducts(){
        return List.of();
    }
}
