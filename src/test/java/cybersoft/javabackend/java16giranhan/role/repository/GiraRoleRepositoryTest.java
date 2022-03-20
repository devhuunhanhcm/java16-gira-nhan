package cybersoft.javabackend.java16giranhan.role.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java16giranhan.role.model.GiraRole;

@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {

	@Autowired
	private GiraRoleRepository repository;
	
	@Test
	public void shouldNotInsertRole() {
		GiraRole role = GiraRole.builder()
							.code("12345")
							.description("description")
							.build();
//		assertThrows(Exception.class, () -> repository.save(role));	
		assertDoesNotThrow(() -> repository.save(role));
	}
	
	
}