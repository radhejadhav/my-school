package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import school.admin.entities.SystemUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findSystemUserByUsername(@Param("email") String username);
}
