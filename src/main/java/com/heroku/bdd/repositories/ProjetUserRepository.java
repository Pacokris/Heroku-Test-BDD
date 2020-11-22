package com.heroku.bdd.repositories;

import com.heroku.bdd.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetUserRepository extends JpaRepository<Users, Long> {

    /**
     * Méthode pour récupérer toute les utilisateurs.
     *
     * @param pageable Pagination
     * @return Une liste d'utilisateurs
     */
    Page<Users> findAll(Pageable pageable);
}
