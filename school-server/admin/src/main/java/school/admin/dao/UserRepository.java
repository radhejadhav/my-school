package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import school.admin.entities.Address;
import school.admin.entities.Department;
import school.admin.entities.SystemUser;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);
    Optional<SystemUser> findById(Long id);
    Boolean existsByUsername(String username);

    @Transactional
    @Modifying
    @Query("select id from SystemUser where username=?1")
    Long getIdByUsername(String username);

    @Transactional
    @Modifying
    @Query("update SystemUser u set u.firstName=?2, u.lastName=?3, u.address= ?4 where u.id=?1")
    void updateUserById(Long id, String firstName, String lastName, Address address);

}
