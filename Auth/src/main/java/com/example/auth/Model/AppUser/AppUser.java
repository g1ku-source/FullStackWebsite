package com.example.auth.Model.AppUser;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;
    private final AppUserRole role = AppUserRole.USER;

    public AppUser(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
