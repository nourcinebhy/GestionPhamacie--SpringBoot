package com.nourcine.backend.auth;

import com.nourcine.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @Autowired
    UserRepository userrepos ;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){

        return this.service.register(request);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(service.authenticate(request));
    }
//    @PostMapping("/ajout")
//    public String Ajout(@RequestBody User request){
//        request.setPassword(passwordEncoder.encode(request.getPassword()));
//        this.userrepos.save(request);
//        return "true" ;
//    }

}




