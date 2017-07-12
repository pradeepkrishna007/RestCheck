package rest.token;

import org.springframework.stereotype.Component;

@Component
public class SecretKey {
	
	private String secret;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	

	
}
