package cybersoft.javabackend.java16girahiep.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16girahiep.role.model.GiraGroup;

@Repository
public interface GiraGroupRepository extends JpaRepository<GiraGroup, UUID> {
	
	// jpql
	@Query("SELECT g FROM GiraGroup g JOIN g.roles WHERE g.id = ?1")
	GiraGroup findGroupWithRolesByGroupId(UUID groupId);

}
