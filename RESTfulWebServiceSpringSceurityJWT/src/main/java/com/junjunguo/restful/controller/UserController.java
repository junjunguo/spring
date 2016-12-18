package com.junjunguo.restful.controller;

import com.junjunguo.restful.model.entity.User;
import com.junjunguo.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @CrossOrigin
    @RequestMapping(path = "/list/", method = RequestMethod.GET)
    public ResponseEntity listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found!");
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

//    @CrossOrigin
    @RequestMapping(path = "/name/{name}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByName(
            @PathVariable("name")
                    String name) {
        User user = userService.findByName(name);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

//    @CrossOrigin
    @RequestMapping(path = "/email/{email:.+}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByEmail(
            @PathVariable("email")
                    String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

//    @CrossOrigin
    @RequestMapping(path = "login/", method = RequestMethod.POST)
    public ResponseEntity login(
            @RequestBody
                    User user) {
        User us = userService.findByEmail(user.getEmail());
        if (us != null && us.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<User>(us, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user name or password not correct!");
    }

//    @CrossOrigin
    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity createUser(
            @RequestBody
                    User user, UriComponentsBuilder ucBuilder) {
        log("create user" + user.toString());
        if (userService.isUserExist(user.getEmail())) {
            //            throw new CustomerException(HttpStatus.NOT_FOUND, "User already exist!");
            // exceptions send too much data to client: which may cause security issues.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already exist!");
        }
        userService.addUser(user);
        //        HttpHeaders headers = new HttpHeaders();
        //        headers.setLocation(ucBuilder.path("/user/email/{email}").buildAndExpand(user.getEmail()).toUri());
        //        log("created ");
        return ResponseEntity.status(HttpStatus.OK).body("succeed!");
    }

//    @CrossOrigin
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity updateUser(
            @RequestBody
                    User user) {
        log("user " + user.toString());

        User currentUser = userService.findByEmail(user.getEmail());
        log("current " + currentUser);
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not registered!");
        }
        userService.updateUser(user);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

//    @CrossOrigin
    @RequestMapping(path = "{email:.+}/", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(
            @PathVariable("email")
                    String email) {
        log("delete " + email);
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        userService.deleteUserByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete succeed!");
    }

    public void log(String s) {

        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }
}