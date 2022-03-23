package cybersoft.javabackend.java16girahiep.role.dto;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
public class GiraRoleDTO {
	@Size(min = 5, max = 5, message = "Role Code must be 5 characters.")
	private String code;
	
	@NotBlank(message = "Description must be not blank.")
	private String description;
}
