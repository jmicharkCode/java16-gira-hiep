package cybersoft.javabackend.java16girahiep.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.javabackend.java16girahiep.common.model.BaseEntity;
import cybersoft.javabackend.java16girahiep.user.model.GiraUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_group")
public class GiraGroup extends BaseEntity {
	// id, code, description, roles

	private String code;
	private String description;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
		name 		= "gira_group_role",
		joinColumns = @JoinColumn(name = "group_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<GiraRole> roles = new LinkedHashSet<GiraRole>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
		name = "gira_group_user",
		joinColumns = @JoinColumn(name = "group_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<GiraUser> users = new LinkedHashSet<GiraUser>();
	
	public void addRole(GiraRole role) {
		roles.add(role);
		role.getGroups().add(this);
	}
	
	public void removeRole(GiraRole role) {
		roles.remove(role);
		role.getGroups().remove(this);
	}
	
	public void clearRole() {
		this.roles.clear();
	}
}