package com.dictionary.ws.core.SecurityConfiguration;

import com.dictionary.ws.entities.concretes.User;

public class authUserResponse {

    private CustomUserDetails user;
    private String token;

    public authUserResponse(CustomUserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

    public authUserResponse() {
    }

    public CustomUserDetails getUser() {
        return user;
    }

    public void setUser(CustomUserDetails user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
