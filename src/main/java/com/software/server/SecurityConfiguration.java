package com.software.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("user")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((request) ->
                        request
                                .requestMatchers(HttpMethod.GET, "/api/v1/servers")
                                .hasRole("user")
                                .requestMatchers(HttpMethod.GET, "/api/v1/serversWithMultipleApplications")
                                .hasRole("user")
                                .requestMatchers(HttpMethod.GET, "/api/v1/servers/**")
                                .hasRole("user")
                                .requestMatchers(HttpMethod.POST, "/api/v1/servers")
                                .hasRole("admin")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/servers/**")
                                .hasRole("admin")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/servers/**")
                                .hasRole("admin")
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .csrf().disable()
                .formLogin().disable();

        return http.build();
    }

}
