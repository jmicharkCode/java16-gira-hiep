package cybersoft.javabackend.java16girahiep.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraGroupDTO {
	private UUID id;
	
	@Size(min = 5, max = 36, message = "{group.code.size}")
	private String code;
	
	@NotBlank(message = "{group.description.notblank}")
	private String description;
}