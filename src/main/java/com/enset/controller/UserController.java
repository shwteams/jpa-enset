package com.enset.controller;


import com.enset.entites.Role;
import com.enset.entites.User;
import com.enset.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public ResponseEntity ajouterUtilisateur(@Valid @RequestBody User user){
        userService.addNewUser(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addRole")
    public ResponseEntity ajouterRole(@Valid @RequestBody Role role){
        userService.addNewRole(role);
        return new ResponseEntity(role, HttpStatus.CREATED);
    }

    @PostMapping(value = "/donnerRoleUser")
    public ResponseEntity donnerRoleUser(String username, String role)  {
        userService.addRoleToUser("root","ROLE_USER");
        return new ResponseEntity("Association réussi.", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getUserByName/{username}")
    public ResponseEntity getUserByName( @PathVariable("username") String username) {
        if(!(username.isBlank() || username.isEmpty())){
            User user = userService.findUserByUserName(username);
            if(user.getId() == null ){
                return new ResponseEntity("Cet utilisateur n'existe pas.", HttpStatus.OK);
            }
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity("Impossible de rechercher un utilisateur vide.", HttpStatus.BAD_REQUEST);
    }

}
