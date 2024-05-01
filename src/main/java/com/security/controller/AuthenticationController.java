//package com.security.controller;
//
//import com.security.domain.user.AuthenticationDto;
//import com.security.domain.user.LoginResponseDto;
//import com.security.domain.user.RegisterDto;
//import com.security.domain.user.User;
//import com.security.repositories.UserRepository;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("auth")
//public class AuthenticationController {
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    UserRepository userRepository;
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid AuthenticationDto authenticationDto){
//        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(),
//                authenticationDto.password());
//        var auth = this.authenticationManager.authenticate(usernamePassword);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody @Valid RegisterDto registerDto){
//        if(this.userRepository.findByLogin(registerDto.login()) != null){
//            return ResponseEntity.badRequest().build();
//        }
//        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
//        User newUser = new User(registerDto.login(), encryptedPassword, registerDto.role());
//
//        userRepository.save(newUser);
//        return ResponseEntity.ok().build();
//    }
//}
