package com.heroku.bdd.service;

import com.heroku.bdd.model.Users;
import com.heroku.bdd.repositories.ProjetUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    /**
     * Méthode pour récupérer un utilisateur par son id.
     *
     * @param user_id L'id de l'utilisateur
     * @return Un utilisateur
     */
    public Optional<Users> findById(Long user_id) {
        return repository.findById( user_id );
    }

    /**
     * Méthode pour ajouter un user.
     *
     * @param user Un utilisateur
     * @return L'utilisateur ajouté
     */
    public Users saveUser(Users user) {
        return repository.save( user );
    }
}
