package com.heroku.bdd.service;

import com.heroku.bdd.model.Users;
import com.heroku.bdd.repositories.ProjetUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceUsers {

    private final ProjetUserRepository repository;

    private final PageRequest pageRequest = PageRequest.of( 0, 5000 );

    public ServiceUsers(ProjetUserRepository repository) {
        this.repository = repository;
    }

    /**
     * Méthode pour récupérer toute les utilisateurs.
     *
     * @return Une liste d'utilisateurs
     */
    public Page<Users> listAll() {
        return repository.findAll( pageRequest );
    }

}
