package com.acciojob.spring_security_integration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configurable
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){

        UserDetails user = User.withUsername("Yash")
                .password(passwordEncoder.encode("Yash123"))
                .roles("USER")
                .build();


        UserDetails admin = User.withUsername("Prathik")
                .password(passwordEncoder.encode("Prathik123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);

    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("hiiAll")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("hiiAdmin","hiUser")
                .authenticated().and().formLogin().and().build();

    }
}
