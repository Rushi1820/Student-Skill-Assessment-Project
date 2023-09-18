package Student.Skill.Assessment.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Service
public class JwtService {

    @Value("${secret.key}")
    private String SECRET_KEY;
    @Value("${secret.validityInHours}")
    private int validityInHours;
    private final Key signingKey;

    public JwtService() {
        // Initialize the signingKey with a secure key of at least 256 bits (32 bytes)
        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
    }



    public Key getSigningKey() {
        return signingKey;
    }

    public String generateToken(UserPrinciple userPrinciple) {
        return generateToken(new HashMap<>(), userPrinciple);
    }

    public String generateToken(Map<String, Object> extraClaims, UserPrinciple userPrinciple) {

        log.info(userPrinciple.getUsername());
        extraClaims.put("roles", userPrinciple.getAuthorities());
        extraClaims.put("user_id", userPrinciple.getUserId());
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((new Date()).getTime() + validityInHours * 3600000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String refreshToken(String token) {
        final Claims claims = extractAllClaims(token);
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        return Jwts
                .builder()
                .setClaims(claims)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUserName(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public void blacklistToken(String token) {
        // TODO: Implement this method to blacklist the token
    }
}
