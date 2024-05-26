package com.acciojob.spring_security_integration;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIs {

    @GetMapping("hiiAll")
    public String sayHello(){
        return "Hello EveryOne! Welcome to hackerBano.com ";
    }

    @GetMapping("hiiAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String hiiAdmin(){
        return "Hello Admin! Welcome to hackerBano.com.., You have been authenticated ";
    }

    @GetMapping("hiiUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String hiiUser(){
        return "Hello User! Welcome to hackerBano.com.., you have been authenticated";
    }
}
