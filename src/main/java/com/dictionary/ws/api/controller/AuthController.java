package com.dictionary.ws.api.controller;

import com.dictionary.ws.business.concretes.AuthManager;
import com.dictionary.ws.core.CustomAnnotation.CurrentUser;
import com.dictionary.ws.core.SecurityConfiguration.CustomUserDetails;
import com.dictionary.ws.core.SecurityConfiguration.authUser;
import com.dictionary.ws.core.SecurityConfiguration.authUserResponse;
import com.dictionary.ws.entities.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {


public final AuthManager authManager;

    public AuthController(AuthManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping(path = "/api/auth")
    public authUserResponse handleAuth(@RequestBody authUser authUser) {
      return authManager.authenticate(authUser);


    }
}
