package com.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class SampleRestController {

    @GetMapping("/e2e")
    public String greetingsToE2E(HttpServletResponse response) {
        return "Hello End-2-End Team";
    }


    /*
    Note that this is a post call and you can call this from postman.
     */
    @PostMapping("/hello")
    public String helloWorld(HttpServletResponse response) {
        return "Hello World";
    }
}
