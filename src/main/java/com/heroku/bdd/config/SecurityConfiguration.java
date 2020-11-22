package com.heroku.bdd.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Classe de configuration pour gérer la sécurité de l'application.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers( EndpointRequest.toAnyEndpoint() ).permitAll()
                .antMatchers( "/" ).permitAll()
                .and()
                .httpBasic();

        //Desactive la securité csfr pour autoriser le RefreshScope
        http
                .csrf()
                .ignoringAntMatchers( "/actuator/**" )
                .disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers( "/" );
    }
}
