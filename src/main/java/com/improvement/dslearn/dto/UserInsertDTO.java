package com.improvement.dslearn.dto;

import com.improvement.dslearn.entities.User;

public class UserInsertDTO extends UserDTO {

    private String password;

    public UserInsertDTO(User entity, String password) {
        super(entity);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
