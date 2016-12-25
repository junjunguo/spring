package com.junjunguo.jwt.controller;

import com.junjunguo.jwt.model.entity.User;
import com.junjunguo.jwt.security.ChangePassword;
import com.junjunguo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 24/12/2016.
 */
@RestController
@RequestMapping(path = "/user/")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(path = "list/", method = RequestMethod.GET)
    public ResponseEntity listAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users registered!");
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "name/{name}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByName(@PathVariable("name") String name) {
        List<User> user = userService.findByName(name);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return new ResponseEntity<List>(user, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "email/{email:.+}/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByEmail(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "login/", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        log(user.getEmail() + " " + user.getPassword());
        User us = userService.findByEmail(user.getEmail());
        if (us != null && us.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<User>(us, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user name or password not correct!");
    }

    @CrossOrigin
    @RequestMapping(path = "register/", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User user) {
        log("create user " + user.toString());
        if (userService.isExist(user.getEmail())) {
            //            throw new CustomerException(HttpStatus.NOT_FOUND, "User already exist!");
            // exceptions send too much data to client: which may cause security issues.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already exist!");
        }
        userService.create(user);
        //        HttpHeaders headers = new HttpHeaders();
        //        headers.setLocation(ucBuilder.path("/user/email/{email}").buildAndExpand(user.getEmail()).toUri());
        //        log("created ");
        return ResponseEntity.status(HttpStatus.OK).body("succeed!");
    }

    @CrossOrigin
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody User user) {
        log("user " + user.toString());

        User currentUser = userService.findByEmail(user.getEmail());
        log("current " + currentUser);
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not registered!");
        }
        userService.update(currentUser, user);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "password/", method = RequestMethod.PUT)
    public ResponseEntity changePassword(@RequestBody ChangePassword changePassword) {
        User currentUser = userService.findByEmail(changePassword.getEmail());
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not found!");
        }
        if (new BCryptPasswordEncoder().matches(changePassword.getOldPassword(), currentUser.getPassword())) {
            userService.changePassword(currentUser, changePassword.getNewPassword());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password not correct!");
        }
        return ResponseEntity.ok("succeed!");
    }

    @CrossOrigin
    @RequestMapping(path = "{email:.+}/", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("email") String email) {
        log("delete " + email);
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        userService.deleteByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete succeed!");
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }
}