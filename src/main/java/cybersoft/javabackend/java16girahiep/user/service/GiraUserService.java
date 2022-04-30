package cybersoft.javabackend.java16girahiep.user.service;

import java.util.List;

import cybersoft.javabackend.java16girahiep.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16girahiep.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16girahiep.user.dto.GiraUserWithRolesDTO;

public interface GiraUserService {
	GiraUserDTO createNewUser(GiraUserDTO dto);

	List<GiraUserRolesDTO> findUserWithRolesByUsername(String username);

	GiraUserWithRolesDTO findUserWithRolesByUsernameUsingJoin(String username);
}