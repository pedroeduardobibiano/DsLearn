package com.improvement.dslearn.dto;

import com.improvement.dslearn.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserLoggedDTO {

    private Long id;
    private String name;
    private String email;

    private final List<String> roles = new ArrayList<>();

    public UserLoggedDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        for (GrantedAuthority role : entity.getRoles()) {
            roles.add(role.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

}
