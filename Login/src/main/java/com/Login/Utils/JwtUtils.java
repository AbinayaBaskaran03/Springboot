package com.Login.Utils;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.Login.Entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private String secret = "secret-key";
	private static long expiryDuration = 60 * 60;

	public String generateJwt(UserEntity userEntity) {

		long milliTime = System.currentTimeMillis();
		long expirationTime = milliTime + expiryDuration * 1000;

		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expirationTime);

// claims
		Claims claims = Jwts.claims().setIssuer(userEntity.getId().toString()).setIssuedAt(issuedAt)
				.setExpiration(expiryAt);

		claims.put("user_type", userEntity.getUserType());
		claims.put("name", userEntity.getName());
		claims.put("emailId", userEntity.getEmailId());

//generate Jwt using claims
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, secret).setClaims(claims).compact();

	}

}
