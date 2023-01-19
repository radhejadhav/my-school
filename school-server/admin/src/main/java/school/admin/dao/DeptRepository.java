package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import school.admin.entities.Department;
import school.admin.entities.Role;
import school.admin.entities.RolesEnum;

import java.util.Optional;

public interface DeptRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Transactional
    @Modifying
    @Query("update Department d set d.name=?2 where d.id = ?1")
    int updateDeptById(Long id, String name);
}
