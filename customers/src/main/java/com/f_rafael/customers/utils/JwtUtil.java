package com.f_rafael.customers.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.f_rafael.customers.entities.User;

import java.util.Date;

public class JwtUtil { //Informacion en: https://www.baeldung.com/java-auth0-jwt

    private static final String SECRET_KEY = "4r4urfrfh";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    public static String generateToken(User user){

        String token = JWT.create()
                .withIssuer("RafaelAlvarez")
                .withClaim("userId", user.getId())
                .withIssuedAt(new Date()) // fecha de creacion
                .withExpiresAt(getExpirationDate()) //fecha de expiracion
                .sign(algorithm);

        return token;
    }

    private static Date getExpirationDate(){
        return new Date(System.currentTimeMillis()+ (1000L * 60 * 60 * 24 * 14)); // 14 days
    }

    public static String getUserIdByToken(String token){
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("RafaelAlvarez")
                .build();

        DecodedJWT decoded = verifier.verify(token);

        String userId = decoded.getClaim("userId").asString();

        return userId;
    }
}
