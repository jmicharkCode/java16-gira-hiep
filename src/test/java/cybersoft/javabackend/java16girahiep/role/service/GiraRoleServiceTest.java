package cybersoft.javabackend.java16girahiep.role.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import cybersoft.javabackend.java16girahiep.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16girahiep.role.mapper.GiraRoleMapper;
import cybersoft.javabackend.java16girahiep.role.model.GiraRole;
import cybersoft.javabackend.java16girahiep.role.repository.GiraRoleRepository;


@DisplayName("Gira Role Service")
@SpringBootTest
public class GiraRoleServiceTest {
	@Mock
	private GiraRoleRepository repository;
	
	@Mock
	private GiraRoleMapper mapper;
	
	@InjectMocks
	private GiraRoleService service = new GiraRoleServiceImpl();
	
	@Test
	public void shouldMockCorrectly() {
		UUID roleId = UUID.randomUUID();
		GiraRole role = GiraRole.builder()
						.id(roleId)
						.code("TEST_ROLE")
						.description("Role for test")
						.build();
		
		// mình sẽ giả định khi repository findById một cái th girarole
		// dùng when
		when(repository.findById(roleId)).thenReturn(Optional.ofNullable(role));
		
		GiraRole actualRole = repository.findById(roleId).get();
		
		assertEquals(roleId, actualRole.getId());
		assertEquals("TEST_ROLE", actualRole.getCode());
		assertEquals("Role for test", actualRole.getDescription());
	}
	
	@DisplayName("should return empty list when no entity found")
	@Test
	public void shouldReturnAllEntityCorrectlyWhenNoEntityFound() {
		when(repository.findAll()).thenReturn(List.of());
		
		List<GiraRoleDTO> roles = service.findAllEntity();
		
		assertEquals(0, roles.size());
	}
	
	@DisplayName("should return correct DTO when there is only one entity found")
	@Test
	public void shouldReturnCorrectDTOWhenOneEntityFound() {
		UUID roleId = UUID.randomUUID();
		GiraRole role = GiraRole.builder()
						.id(roleId)
						.code("TEST_ROLE")
						.description("Role for test")
						.build();
		
		GiraRoleDTO dto = GiraRoleDTO.builder()
						.id(roleId)
						.code("TEST_ROLE")
						.description("Role for test")
						.build();
		
		// khi repository xài findAll thì trả ra list của role
		when(repository.findAll()).thenReturn(List.of(role));
		// muon th role khi nó map phải ra dto ( do hàm service có lq đến instance repository)
		when(mapper.toGiraRoleDTO(role)).thenReturn(dto);
		// khi này service xài method findAllEntity xong trong đó lại gọi đến repository.findAll
		// và dùng cái return của trên để ra một cái list dto
		List<GiraRoleDTO> actualRoles = service.findAllEntity();
		
		assertEquals(1, actualRoles.size());
		
		GiraRoleDTO actualRole = actualRoles.get(0);
		
		assertEquals(roleId, actualRole.getId());
		assertEquals("TEST_ROLE", actualRole.getCode());
		assertEquals("Role for test", actualRole.getDescription());
	}
}
