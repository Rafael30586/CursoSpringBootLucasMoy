package com.f_rafael.customers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    CustomAccesFilter customAccesFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
/*
        http.authorizeHttpRequests(request -> {
            request.requestMatchers("api/register","api/login").permitAll();
            request.requestMatchers("api/**").authenticated();
        });*/

        http.addFilterBefore(customAccesFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }
}
