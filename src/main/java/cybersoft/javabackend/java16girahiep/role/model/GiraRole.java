package cybersoft.javabackend.java16girahiep.role.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table( name = "gira_role")
public class GiraRole {
	// id, code, description, role
	@Id
	@Type(type = "uuid-char")
	@GeneratedValue
	private UUID id;
	private String code;
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	private Set<GiraGroup> groups = new LinkedHashSet();
	
}
