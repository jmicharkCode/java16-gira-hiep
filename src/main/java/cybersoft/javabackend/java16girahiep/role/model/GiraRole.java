package cybersoft.javabackend.java16girahiep.role.model;



import java.util.LinkedHashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java16girahiep.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder	
@Entity
@Table( name = "gira_role")
public class GiraRole extends BaseEntity{
	// constraint: 5 character
	@Size(min = 5, max = 100)
	private String code;
	
	@NotBlank
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	private Set<GiraGroup> groups = new LinkedHashSet();
	
}
