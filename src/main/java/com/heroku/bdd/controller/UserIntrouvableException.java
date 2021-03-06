package com.heroku.bdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIntrouvableException extends RuntimeException {
    public UserIntrouvableException(String s) {
        super(s);
    }
}
