package com.heroku.bdd.controller;


import com.heroku.bdd.model.Users;
import com.heroku.bdd.service.ServiceUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@Validated
@RequestMapping("/user")
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

}
