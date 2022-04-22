package cybersoft.javabackend.java16giranhan.security.jwt;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtHelperTest {
	@Autowired
	private JwtHelper helper;
	
	@Test
	public void shouldBeInjectedSuccessfully() {
		assertNotNull(helper);
	}
}
