package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import school.admin.entities.SystemUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);
    Optional<SystemUser> findById(Long id);
    Boolean existsByUsername(String username);
}
