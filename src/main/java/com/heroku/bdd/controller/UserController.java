package com.heroku.bdd.controller;


import com.heroku.bdd.model.Users;
import com.heroku.bdd.service.ServiceUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@CrossOrigin
@Slf4j
@Validated
@RequestMapping("user")
public class UserController {

    private final ServiceUsers serviceUsers;

    public UserController(ServiceUsers serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    /**
     * Permet de récupérer la liste de tous les utilisateurs.
     *
     * @return Une liste
     */
    @ResponseBody
    @GetMapping(value = "/allUsers")
    public Page<Users> findAllUsers() {
        return serviceUsers.listAll();
    }

    /**
     * Permet de créer un utilisateur.
     *
     * @param user Un utilisateur
     * @return L'utilisateur créé
     */
    @ResponseBody
    @PostMapping(value = "/addUsers")
    public ResponseEntity<Void> ajouterUser(@Valid @RequestBody Users user) {

        Users userAdded = serviceUsers.saveUser( user );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( userAdded.getUser_id() )
                .toUri();

        return ResponseEntity.created( location ).build();
    }

}
