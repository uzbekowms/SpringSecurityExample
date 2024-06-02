package edu.itstep.security.domain.model;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "roles")
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    public static enum Role {
//        ROLE_USER, ROLE_ADMIN
//    }
//}