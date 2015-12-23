package com.junjunguo.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This file is part of spring_on_web.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/15.
 */
@Controller                                     // Declared to be a controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
    @RequestMapping(value = {"/", "/homepage"},
                    method = RequestMethod.GET) // Handle GET requests for
    public String home() {
        return "home";                          // View name is home
    }
}
