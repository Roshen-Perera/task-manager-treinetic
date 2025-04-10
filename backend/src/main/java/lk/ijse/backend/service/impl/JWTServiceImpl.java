package lk.ijse.backend.service.impl;

import io.jsonwebtoken.Claims;
import lk.ijse.backend.service.JWTService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public class JWTServiceImpl implements JWTService {
    @Override
    public String extractUserName(String token) {
        return "";
    }

    @Override
    public Claims extractAllClaims(String token) {
        return null;
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimResolve) {
        return null;
    }

    @Override
    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
        return "";
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return "";
    }
}
