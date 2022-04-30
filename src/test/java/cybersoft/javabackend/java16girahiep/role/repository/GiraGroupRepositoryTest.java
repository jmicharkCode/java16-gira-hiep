package cybersoft.javabackend.java16girahiep.role.repository;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class GiraGroupRepositoryTest {
	
	@Autowired
	GiraGroupRepository repository;
	
	@BeforeAll
	public void setUp() {
		
	}
	
	@Test
	public void shouldFetchGroupWithRoles() {
		assertDoesNotThrow( () -> {
					repository.findGroupWithRolesByGroupId(UUID.fromString("cfc69680-a188-4c48-a481-f2b7ce59e3db"));
					});
	}
}
