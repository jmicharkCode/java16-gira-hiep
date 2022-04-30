package cybersoft.javabackend.java16girahiep.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16girahiep.security.dto.LoginDTO;
import cybersoft.javabackend.java16girahiep.security.jwt.JwtHelper;
import cybersoft.javabackend.java16girahiep.user.model.GiraUser;
import cybersoft.javabackend.java16girahiep.user.repository.GiraUserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private GiraUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtHelper jwts;
	
	@Override
	public String login(LoginDTO dto) {
		
		// get user info
		Optional<GiraUser> userOpt = repository.findByUsername(dto.getUsername());
			
		// check password
		String encodedPassword = userOpt.get().getPassword();

		if(passwordEncoder.matches(dto.getPassword(), encodedPassword)) 
			return jwts.generateJwtToken(dto.getUsername());
		
		return null;
	}
	
}