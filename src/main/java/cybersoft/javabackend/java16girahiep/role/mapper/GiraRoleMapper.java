package cybersoft.javabackend.java16girahiep.role.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16girahiep.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16girahiep.role.model.GiraRole;

@Mapper
public interface GiraRoleMapper {
	GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	
	GiraRole mapToEntity(GiraRoleDTO dto);
}
