package com.alura_foro.Alura_foro.token;

import com.alura_foro.Alura_foro.modelos.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;


@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret = "p2maNI21983*";

    private DecodedJWT verifier;
    public static String userName;

    private TokenService (DecodedJWT verifier) {
        this.verifier = verifier;
    }
    public String generarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Alura Foro")
                    .withSubject(usuario.getUsuario())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarInstant())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    public String getSubject(String token) {
        System.out.println(token);
        if (token == null) {
            throw new RuntimeException();
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            verifier = JWT.require(algorithm)
                    .withIssuer("Alura Foro")
                    .build()
                    .verify(token);
            verifier.getSubject();
            userName = verifier.getSubject();

        }catch (JWTVerificationException e){
            System.out.println(e.getMessage());
        }
        if(verifier.getSubject() == null){
            throw new RuntimeException("Sesión no encontrada");
        }
        return verifier.getSubject();
    }

    public Date generarInstant() {
        return Date.from(Instant.now().plusSeconds(7200));

}



}

