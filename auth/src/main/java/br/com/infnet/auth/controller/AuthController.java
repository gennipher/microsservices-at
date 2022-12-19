package br.com.infnet.auth.controller;

import br.com.infnet.auth.model.User;
import br.com.infnet.auth.service.AuthService;
import br.com.infnet.auth.service.TokenService;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    TokenService tokenService;
    @PostMapping
    public ResponseEntity authenticate(@RequestBody User user) {
        User isAuthed = authService.autenticar(user);
        if(isAuthed == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("Message", "Not Authorized"));
        }
        String token = tokenService.generateToken(isAuthed);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/verify")
    public ResponseEntity verify(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        if(!token.startsWith("Bearer")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST). body(Map.of("Message", "Invalid Token"));
        } else {
            token = token.replace("Bearer", "").trim();
            DecodedJWT validate = tokenService.validate(token);
            if(validate == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Message", "Invalid Token"));
            } else {
                return ResponseEntity.ok(Map.of("Message", "Valid Token"));
            }
        }
    }
}
