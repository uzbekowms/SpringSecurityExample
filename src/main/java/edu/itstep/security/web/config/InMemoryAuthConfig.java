package edu.itstep.security.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemoryAuthConfig {

//    @Bean
//    public UserDetailsService inMemoryUserDetailsService(AuthenticationManagerBuilder builder, InMemoryUserDetailsManager manager) throws Exception {
//        builder.inMemoryAuthentication()
//                .withUser("Test").password("test").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
//        UserDetails testUser = User.withUsername("test")
//                .password("test")
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
//                .roles("USER")
//                .build();
//
//        UserDetails adminUser = User.withUsername("admin")
//                .password("admin")
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
//                .roles("ADMIN")
//                .build();
//        manager.createUser(testUser);
//        manager.createUser(adminUser);
//        return manager;
//    }

}
