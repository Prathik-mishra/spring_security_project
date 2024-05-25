package com.acciojob.spring_security_integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIs {

    @GetMapping("hiiAll")
    public String sayHello(){
        return "Hello EveryOne! Welcome to hackerBano.com ";
    }
}
