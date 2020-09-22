package com.shongrimes.tabletalk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import javax.validation.constraints.*;

@Entity
public class User {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Id
    @NotBlank(message = "Username cannot be blank")
    @Size(min=3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min=8, message = "Password must be at least 8 characters")
    private String password;

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User (){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username == user.username;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
