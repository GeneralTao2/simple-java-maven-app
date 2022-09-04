package com.mycompany.app;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctr {

    @GetMapping("/get")
    public String test() {
        return "Test!1 Yea!";
    }
}
