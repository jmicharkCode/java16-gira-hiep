package cybersoft.javabackend.java16girahiep.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16girahiep.user.model.GiraUser;
import cybersoft.javabackend.java16girahiep.user.repository.GiraUserRepository;
import cybersoft.javabackend.java16girahiep.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	private String message;
	
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public void initialize(UniqueUsername uniqueUsername) {
		message = uniqueUsername.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(username == null)
			return false;
		
		Optional<GiraUser> userOpt = repository.findByUsername(username);
		
		if(userOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
	
}