package cybersoft.javabackend.java16girahiep.security.service;

import cybersoft.javabackend.java16girahiep.security.dto.LoginDTO;

public interface AuthService {
	String login(LoginDTO dto);
	
}
