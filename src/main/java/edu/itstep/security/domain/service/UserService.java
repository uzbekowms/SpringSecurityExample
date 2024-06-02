package edu.itstep.security.domain.service;

import edu.itstep.security.domain.model.Role;
import edu.itstep.security.domain.model.User;
import edu.itstep.security.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }


    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already taken");
        }

        return save(user);
    }


    public User getByUsername(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }


    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return getByUsername(username);
    }


    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}
