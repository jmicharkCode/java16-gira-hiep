package cybersoft.javabackend.java16girahiep.user.repository;

import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16girahiep.user.model.GiraUser;

@Repository
public interface GiraUserRepository extends JpaRepository<GiraUser, UUID> {
	Optional<GiraUser> findByUsername(String username);

	Optional<GiraUser> findByEmail(String email);

}
