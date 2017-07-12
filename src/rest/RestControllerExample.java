package rest;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.model.User;
import rest.token.CreateToken;
import rest.token.DecodeToken;

@RestController
public class RestControllerExample {
	

	@RequestMapping(value = "/pass", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public synchronized ResponseEntity<String> createUser(@RequestBody User user) {

		System.out.println("Employee phone " + user.getId());
		System.out.println("Employee phone " + user.getSubject());

		CreateToken ck = new CreateToken();
		String jwtSting = ck.createJWT("" + user.getId(), user.getIssuer(), user.getSubject(), user.getTtlMillis());

		HttpHeaders headers = new HttpHeaders();
		headers.add("jwtSting", jwtSting);

		DecodeToken dtk = new DecodeToken();
		User userOutput = dtk.parseJWT(jwtSting);

		ObjectMapper mapper = new ObjectMapper();
		String JsonOut=null;
		try {
			JsonOut = mapper.writeValueAsString(userOutput);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		headers.add("decodedOutput", JsonOut);
		return new ResponseEntity<String>("Converted successfully", headers, HttpStatus.OK);
	}

}