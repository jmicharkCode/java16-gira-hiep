package cybersoft.javabackend.java16girahiep.role.service;

import java.util.List;


import cybersoft.javabackend.java16girahiep.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16girahiep.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRole> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}
