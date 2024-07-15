package challenge.alura.apiforo.infra.security;

import com.auth0.jwt.JWT;
import challenge.alura.apiforo.domain.usuario.Usuario;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return  JWT.create()
                    .withIssuer("foro alura")
                    .withSubject(usuario.getNombre())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    public String getSubject(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return  JWT.require(algorithm)
                    .withIssuer("foro alura")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTCreationException exception){
            throw new RuntimeException(exception.toString());
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
