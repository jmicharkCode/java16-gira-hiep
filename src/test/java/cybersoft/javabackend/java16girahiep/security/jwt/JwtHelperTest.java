package cybersoft.javabackend.java16girahiep.security.jwt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import cybersoft.javabackend.java16girahiep.user.model.GiraUser;

@SpringBootTest
public class JwtHelperTest {
	@Autowired
	private JwtHelper helper;
	
	@Test
	public void shouldBeInjectedSuccessfully() {
		assertNotNull(helper);
	}
	
	@Test
	public void shouldGenerateJwtTokenSuccessfully() {
		GiraUser user = GiraUser.builder()
						.username("testuser")
						.build();
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, null);
		
		String jwt = helper.generateJwtToken(user.getUsername());
		
		assertNotNull(jwt);
	}
}
