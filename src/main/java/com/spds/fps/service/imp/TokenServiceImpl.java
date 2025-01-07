package com.spds.fps.service.imp;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.spds.fps.entity.User;
import com.spds.fps.service.TokenService;
import com.spds.fps.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private Long jwtExpiration;

	@Value("${jwt.refresh-token.expiration}")
	private Long refreshTokenExpiration;

	private final KeyStore keyStore;

	private UserService userService;

	@Autowired
	public TokenServiceImpl(UserService userService)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
		this.userService = userService;
		keyStore = KeyStore.getInstance("JKS");
		keyStore.load(null, null);
	}

	public Authentication getAuthentication(String token) throws Exception {
		validateToken(token);
		Claims claims = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
		User user = userService.getUserDetails(Long.valueOf(claims.getSubject()));
		return new UsernamePasswordAuthenticationToken(user, null, null);

	}

	private boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			return false;
		}
		return true;

	}

	private Key getSignKey() {
		// Decode the base64 encoded secret key and return a Key object
		byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
