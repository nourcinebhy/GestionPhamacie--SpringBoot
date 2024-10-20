package com.nourcine.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.nourcine.backend.user.Permission.*;
import static com.nourcine.backend.user.Role.Admin;
import static com.nourcine.backend.user.Role.USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                // Permit all for testing - Place before any other matchers for this path
                .requestMatchers("/api/produit/**").permitAll()
                .requestMatchers("/api/ventes/**").permitAll()
                // Existing security rules
                .requestMatchers("/api/v1/auth/register", "/api/v1/auth/authenticate", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**")
                .permitAll()
                .requestMatchers("/api/categorie/**").hasAnyAuthority(Admin_READ.name(), USER_READ.name(), Admin_CREATE.name(), USER_CREATE.name(), Admin_UPDATE.name(), USER_UPDATE.name(), Admin_DELETE.name(), USER_DELETE.name())
                .requestMatchers("/api/category/count").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority(Admin_READ.name(), USER_READ.name())
                .requestMatchers(HttpMethod.POST, "/api/user/**").hasAnyAuthority(Admin_CREATE.name(), USER_CREATE.name())
                .requestMatchers(HttpMethod.PUT, "/api/user/**").hasAnyAuthority(Admin_UPDATE.name(), USER_UPDATE.name())
                .requestMatchers(HttpMethod.DELETE, "/api/user/**").hasAnyAuthority(Admin_DELETE.name(), USER_DELETE.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(
//                        req->req.requestMatchers("/api/v1/auth/register","/api/v1/auth/authenticate","/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**")
//                                .permitAll()
//                                .requestMatchers("api/categorie/**").hasAnyAuthority("Admin")
//                                .requestMatchers("api/produit/**").hasAnyAuthority("Admin")
//                                .anyRequest()
//                                .authenticated())
//                .userDetailsService(UserDetails)
//                .sessionManagement()




    }
