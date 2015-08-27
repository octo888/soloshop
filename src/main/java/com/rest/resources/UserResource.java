package com.rest.resources;

import com.core.entity.Role;
import com.core.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class UserResource extends ResourceSupport {

    private String name;

    private String email;

    private String password;

    private String phone;

    private boolean enabled;

    private List<Role> roles;

    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRoles(roles);
        user.setEnabled(enabled);
        return user;
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
