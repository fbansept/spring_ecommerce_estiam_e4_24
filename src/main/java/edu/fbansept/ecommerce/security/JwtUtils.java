package edu.fbansept.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtils {

    String secret = "azerty123";

    public String generateJwt(EcommerceUserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("isSeller", userDetails.isSeller());
        claims.put("isCustomer", userDetails.isCustomer());
        claims.put("isAdmin", userDetails.isAdmin());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractBody(String jwt) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
