package cybersoft.javabackend.java16girahiep.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16girahiep.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16girahiep.role.model.GiraRole;
import cybersoft.javabackend.java16girahiep.role.service.GiraRoleService;

@RestController
@RequestMapping("roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object findAllRoles() {
		List<GiraRole> roles = service.findAllEntity();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewRole(@RequestBody GiraRoleDTO dto) {
		GiraRole role = service.save(dto);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
}
