package cybersoft.javabackend.java16girahiep.role.dto;


import javax.persistence.MappedSuperclass;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class GiraRoleDTO {
	private String code;
	private String description;
}
