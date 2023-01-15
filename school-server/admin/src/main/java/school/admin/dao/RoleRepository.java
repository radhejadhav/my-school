package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import school.admin.entities.Role;
import school.admin.entities.RolesEnum;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RolesEnum name);
}
