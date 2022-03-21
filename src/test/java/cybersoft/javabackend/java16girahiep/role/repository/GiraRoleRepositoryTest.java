package cybersoft.javabackend.java16girahiep.role.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java16girahiep.role.model.GiraRole;

@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {
	
	@Autowired
	private GiraRoleRepository repository;
	
	@Test
	public void shouldNotInsertRole() {
		GiraRole role = GiraRole.builder()
							.code("FOUR")
							.description(null)
							.build();
		
		assertThrows(Exception.class, () -> repository.save(role));
	}
	
}
