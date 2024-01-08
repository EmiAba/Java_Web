package com.bonappetit.service.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {
private Long id;
    private String username;

    private boolean isLogged;


    public String getUsername() {
        return username;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void login(String username) {
        this.username = username;
        this.isLogged = true;
    }

    public void logout() {
        this.username = null;
        this.isLogged = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}