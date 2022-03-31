package cybersoft.javabackend.java16girahiep.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16girahiep.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16girahiep.user.mapper.GiraUserMapper;
import cybersoft.javabackend.java16girahiep.user.model.GiraUser;
import cybersoft.javabackend.java16girahiep.user.repository.GiraUserRepository;

@Service
public class GiraUserServiceImpl implements GiraUserService{
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);	
		GiraUser newUser = repository.save(user);
		
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

}
