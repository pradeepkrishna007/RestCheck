package rest.token;

//Decode and Verify Tokens

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;

import io.jsonwebtoken.Jwts;
import rest.model.User;
import io.jsonwebtoken.Claims;

//Sample method to validate and read the JWT

public class DecodeToken {

/*	@Autowired
	SecretKey apiKey;
	
	

	public SecretKey getApiKey() {
		return apiKey;
	}



	public void setApiKey(SecretKey apiKey) {
		this.apiKey = apiKey;
	}
*/

	

	// Sample method to validate and read the JWT
	public User parseJWT(String jwt) {

		User user = new User();
		// This line will throw an exception if it is not a signed JWS (as
		// expected)
		//Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(apiKey.getSecret())).parseClaimsJws(jwt).getBody();
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("xafrtTTS")).parseClaimsJws(jwt).getBody();
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());

		user.setId(Integer.parseInt(claims.getId()));
		user.setIssuer(claims.getIssuer());
		user.setSubject(claims.getSubject());
		user.setTtlMillis(claims.getExpiration().getTime());

		return user;
	}

}