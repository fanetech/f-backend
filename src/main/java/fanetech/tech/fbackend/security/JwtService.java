package fanetech.tech.fbackend.security;


import fanetech.tech.fbackend.entites.User;
import fanetech.tech.fbackend.service.UtilisateurService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class JwtService {

    private UtilisateurService utilisateurService;
    private final String ENCRIPTION_KEY = "a5819e06b5d412c70238ee5127cc73fdc8475da63508063edaff523c43d86fd1";

    public Map<String, String> generate(String username){
        User user = this.utilisateurService.loadUserByUsername(username);
        return this.generateJwt(user);
    }

    public String extractUsername(String token) {

        return this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
       Date expirationDate = this.getClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    private <T> T getClaim(String token, Function<Claims, T> function) {
        Claims claims = getAllClaims(token);
        return function.apply(claims);
    }

    private Claims getAllClaims(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(this.getkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Map<String, String> generateJwt(User user){
        final long currenTime = System.currentTimeMillis();
        final long expirationTime = currenTime + 30 * 60 * 1000;
        final Map<String, Object> claims = Map.of(
                "nom", user.getNom(),
                Claims.EXPIRATION, new Date(expirationTime),
                Claims.SUBJECT, user.getEmail()
        );

        java.lang.String bearer = Jwts.builder()
                .setIssuedAt(new Date(currenTime))
                .setExpiration(new Date(expirationTime))
                .setSubject(user.getEmail())
                .setClaims(claims)
                .signWith(getkey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("bearer", bearer);
    }

    private Key getkey() {
        byte[] decoder = Decoders.BASE64.decode(ENCRIPTION_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }


}
