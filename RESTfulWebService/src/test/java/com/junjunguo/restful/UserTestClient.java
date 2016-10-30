package com.junjunguo.restful;

import com.junjunguo.restful.model.Gender;
import com.junjunguo.restful.model.db.User;
import com.junjunguo.restful.util.MyDate;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
public class UserTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080" + "/user/";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers() {
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        try {
            List<LinkedHashMap<String, Object>> usersMap = restTemplate
                    .getForObject(REST_SERVICE_URI + "/list/", List.class);

            if (usersMap != null) {
                for (LinkedHashMap<String, Object> map : usersMap) {
                    System.out.println("User :  Name=" + map.get("name") +
                                       ", email=" + map.get("email") +
                                       ", country=" + map.get("country") +
                                       ", password=" + map.get("password") +
                                       ", gender=" + map.get("gender") +
                                       ", registered time=" + map.get("registeredTime") +
                                       ", birth=" + map.get("birth"));
                }
            } else {
                System.out.println("No user exist----------");
            }
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                System.out.println("not found !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }
    }

    /* GET */
    private static void getUserByName(String name) {
        System.out.println("Testing getUserByName by name API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            User user = restTemplate.getForObject(REST_SERVICE_URI + "/name/" + name + "/", User.class);
            System.out.println("find user by name : " + user);
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                System.out.println("user name: {" + name + "} not found !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }

    }

    /* GET */
    private static void getUserByEmail(String email) {
        System.out.println("Testing getUser By Email API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            User user = restTemplate.getForObject(REST_SERVICE_URI + "/email/" + email + "/", User.class);
            if (user != null) {
                System.out.println("get by email: " + user);
            }
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                System.out.println("user with email: {" + email + "} not found !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }
    }

    /* POST */
    private static void createUser(User user) {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = restTemplate.postForLocation(REST_SERVICE_URI, user, User.class);
            System.out.println("Location : " + uri.toASCIIString() + "/");
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.CONFLICT.toString())) {
                System.out.println("user: {" + user.toString() + "} already exist !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }
    }

    /* PUT */
    private static void updateUser(User user) {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.put(REST_SERVICE_URI, user);
            //            restTemplate.put(REST_SERVICE_URI + user.getEmail() + "/", user);
            System.out.println("update user: " + user);
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                System.out.println("user: {" + user + "} not found !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }
    }

    /* DELETE */
    private static void deleteUserByEmail(String email) {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(REST_SERVICE_URI + email + "/");
            System.out.println("user with email: " + email + " deleted");
        } catch (org.springframework.web.client.RestClientException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                System.out.println("user with email: {" + email + "} not found !");
            } else {
                System.out.println("oops! error occurred! " + e.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        createUser(new User("Alf", "wang@ntnu.no", "alf's password"));
        createUser(new User("meng", "zhu@yahoo.com", "meng's password"));
        createUser(new User("ole", "ole@ole.com", "ole's password"));
        createUser(new User("kari", "kari@kari.com", "kari's password", "Norway", Gender.Female,
                new MyDate().getDate("2002-02-02 16:02:37")));
        User guo = new User("guo", "guo@a.a", "guo's password");
        guo.setGender(Gender.Male);
        createUser(guo);
        listAllUsers();
        getUserByName("ole");
        getUserByEmail("wang@ntnu.no");
        getUserByEmail("jonas@gmail.com");
        createUser(new User("Philip", "philip@a.a", "philip's password"));
        listAllUsers();
        updateUser(new User("fei fei", "fei@a.a", "Norway", "fei's password updated",
                new MyDate().getDate("2000-02-02 16:02:37")));
        listAllUsers();
        createUser(new User("Lene", "Lene@gmail.com", "stian's password"));
        createUser(new User("Mariana", "Mariana@gmail.com", "Mariana's password"));
        createUser(new User("Johan", "Johan@ntnu.com", "Johan's password"));
        listAllUsers();
        createUser(new User("Maria", "Maria@hotmail.com", "Maria's password"));
        deleteUserByEmail("ole@ole.com");
        listAllUsers();
    }
}

