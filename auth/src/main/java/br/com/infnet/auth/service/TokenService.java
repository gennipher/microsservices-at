package br.com.infnet.auth.service;

import br.com.infnet.auth.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {
    private String secret = "pqowqiwas";
    public String generateToken(User user){
        Instant expiredAt = Instant.now().plus(30, ChronoUnit.MINUTES);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create().withIssuer("sistema-alunos")
                .withSubject(user.getId().toString()).withIssuedAt(Date.from(Instant.now()))
                .withExpiresAt(Date.from(expiredAt)).withClaim("isAdmin", true).sign(algorithm);
        return token;
    }

    public DecodedJWT validate(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        DecodedJWT verify = null;
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
             verify = verifier.verify(token);
        } catch (JWTVerificationException e) {
            return null;
        }
        return verify;
    }
}
