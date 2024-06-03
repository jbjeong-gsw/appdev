package kr.hs.gbsw.appdev.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtProvider implements InitializingBean {
    private static final String AUTHORIZATION_KEY = "Authorization";

    private static final String SECRET =
            "jait!3G1AG11gAGA@$Agjk2AG#!jait!3G1AG11gAGA@$Agjk2AG#!jait!3G1AG11gAGA@$Agjk2AG#!jait!3G1AG11gAGA@$Agjk2AG#!jait!3G1AG11gAGA@$Agjk2AG#!";

    @Value("${jwt.expiry}")
    private long expiryMillis;

    private Key key;


    @Override
    public void afterPropertiesSet() throws Exception {
        makeSignatureKey();
    }

    public void makeSignatureKey() {
        byte[] bytes = Base64.getEncoder().encode(SECRET.getBytes());
        this.key = Keys.hmacShaKeyFor(bytes);
    }

    public String createToken(Authentication authentication) {
        String authoritiesStr = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        Date expiry = new Date(System.currentTimeMillis() + expiryMillis);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORIZATION_KEY, authoritiesStr)
                .setExpiration(expiry)
                .signWith(this.key)
                .compact();
    }

}
