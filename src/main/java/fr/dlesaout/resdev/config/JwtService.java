package fr.dlesaout.resdev.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "397A24432646294A404E635266556A576E5A7234753778214125442A472D4B6150645367566B59703273357638792F423F4528482B4D6251655468576D5A7134";

    // Méthode prenant en paramètre un token et utilisant la méthode extractClaim() pour extraire le sujet (c'est-à-dire le nom d'utilisateur) de ce jeton.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Méthode prenant en paramètre un token et une fonction qui détermine comment extraire une revendication spécifique (ici Claims::getSubject) de ce token. Utilise également la méthode extractAllClaims() pour extraire toutes les revendications du jeton.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Méthode prenant en paramètre un objet UserDetails qui contient les détails de l'utilisateur (nom d'utilisateur, mot de passe, etc.). Elle utilise la bibliothèque Jwts pour créer un token qui contient le nom d'utilisateur de l'objet UserDetails en tant que sujet, une date d'émission et une date d'expiration. Elle signe également ce token avec une clé secrète.
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Méthode prenant en paramètre un objet UserDetails et un objet Map qui contient des revendications supplémentaires à inclure dans le token.
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    // Méthode prenant en paramètre un token et un objet UserDetails. Elle utilise la méthode extractUsername() pour extraire le nom d'utilisateur du jeton et compare ce nom d'utilisateur à celui de l'objet UserDetails. Elle utilise également la méthode isTokenExpired() pour vérifier si le token a expiré. Elle retourne true si le nom d'utilisateur est valide et si le jeton n'est pas expiré, et false sinon.
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Méthode prenant en paramètre un token et utilise la méthode extractExpiration() pour extraire la date d'expiration du jeton. Elle retourne true si la date d'expiration est avant la date actuelle et false sinon.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Méthode prenant en paramètre un token et utilise la méthode extractClaim() pour extraire la date d'expiration du jeton.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Méthode prenant en paramètre un token et utilise la bibliothèque Jwts pour extraire toutes les revendications de ce jeton en utilisant la clé secrète.
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Méthode utilisant la bibliothèque Decoders pour décoder la clé secrète stockée en tant que constante dans la classe et utilise la bibliothèque Keys pour créer une clé à utiliser pour signer les token.
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
