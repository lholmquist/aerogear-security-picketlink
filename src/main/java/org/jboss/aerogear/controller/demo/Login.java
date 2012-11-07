package org.jboss.aerogear.controller.demo;

import org.jboss.aerogear.controller.demo.model.User;
import org.jboss.aerogear.security.auth.AuthenticationManager;
import org.jboss.aerogear.security.auth.CredentialFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Login {

    @Inject
    private AuthenticationManager authenticationManager;

    @Inject
    private CredentialFactory credentialFactory;

    public void index() {
        System.out.println("Login page!");
    }

    public User login(User user) {

        credentialFactory.setSimpleCredential(user);
        authenticationManager.login(user);

        return user;
    }

    public void logout() {
        System.out.println("User logout!");
        authenticationManager.logout();
    }
}
