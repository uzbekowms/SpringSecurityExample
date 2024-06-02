package edu.itstep.security.web.security;

import org.springframework.stereotype.Service;

@Service
public class CustomSecurityService  {

    public boolean isNorm(int id) {
        return id % 2 == 0;
    }
}
