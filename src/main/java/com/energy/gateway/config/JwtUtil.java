package com.energy.gateway.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    Dotenv dotenv = Dotenv.load();
    private String SECRET_KEY = dotenv.get("SECRET_KEY");

    public boolean isValid(String token) {
        boolean validation = false;
        try {
            Jws<Claims> claims  = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            if(!claims.getBody().getExpiration().before(new Date())){
                validation = true;
            }
            else
            {
                validation = false;
            }

        } catch (ExpiredJwtException e) {
            System.out.println(" Token expired ");
        } catch(Exception e){
            System.out.println(" Some other exception in JWT parsing ");
        }
        return validation;
    }

}
