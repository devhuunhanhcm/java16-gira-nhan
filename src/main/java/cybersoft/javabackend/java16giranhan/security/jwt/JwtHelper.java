package cybersoft.javabackend.java16giranhan.security.jwt;

import java.net.http.HttpRequest;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtHelper {
	private String key = "whatissecret";
	private String prefix = "Bearer ";
	public String generateJwtToken(String username) {
		
		Date currentDate = new Date();
		
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(currentDate)
					.setExpiration(new Date(currentDate.getTime() + 86400000)) //tính theo milisecond s
					.signWith(SignatureAlgorithm.HS512,key)
					.compact();
		
		
	}

	public boolean validationJwt(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return true;
		}catch(UnsupportedJwtException e1) {
			log.error("Jwt token is not supported: {}",e1);
		}
		catch(MalformedJwtException e2) {
			log.error("Invalid token: {} ",e2);		
		}
		catch(SignatureException e3) {
			log.error("Invalid token: {} ",e3);	
		}
		catch(ExpiredJwtException e4) {
			log.error("Jwt is expired: {} ",e4);			
		}
		catch(IllegalArgumentException e5) {
			log.error("Jwt claims is empty: {} ");			
		}
		return false;
	}
	public String getToken(HttpServletRequest request) {
		 String jwt = request.getHeader("Authorization");
		 if(jwt == null)
			 return jwt;
		 
		return jwt.substring(prefix.length(), jwt.length());
	}

	public String getUsername(String token) {
		
		return Jwts.parser()
 				.setSigningKey(key)
 				.parseClaimsJws(token)
 				.getBody()
 				.getSubject();
	}
	
	
//	public String generateJwtToken(Authentication authentication) {
//		if(authentication == null) {
//			return null;
//		}
//		UserDetails userDetails =(UserDetails) authentication.getPrincipal();
//		
//		Date currentDate = new Date();
//		
//		
//		return Jwts.builder()
//					.setSubject(userDetails.getUsername())
//					.setIssuedAt(currentDate)
//					.setExpiration(new Date(currentDate.getTime() + 86400))
//					.signWith(SignatureAlgorithm.HS512, "whatissecret")
//					.compact();
//	}
}
