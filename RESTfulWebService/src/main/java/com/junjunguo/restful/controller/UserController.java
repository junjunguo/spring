package com.junjunguo.restful.controller;

import com.junjunguo.restful.model.User;
import com.junjunguo.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/list/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        log("list ....");

        //        ModelAndView

        List<User> users = userService.findAllUsers();
        log("list .... users " + users.toString());
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/name/{name}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByName(
            @PathVariable("name")
                    String name) {
        User user = userService.findByName(name);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/email/{email:.+}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByEmail(
            @PathVariable("email")
                    String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(
            @RequestBody
                    User user, UriComponentsBuilder ucBuilder) {
        log("create user" + user.toString());
        if (userService.isUserExist(user.getEmail())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        log("create user +");
        userService.addUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/email/{email}").buildAndExpand(user.getEmail()).toUri());
        log("created ");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(
            @RequestBody
                    User user) {
        User currentUser = userService.findByEmail(user.getEmail());

        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(path = "{email:.+}/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(
            @PathVariable("email")
                    String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserByEmail(email);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }
}