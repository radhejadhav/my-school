package school.admin.services;

import org.springframework.stereotype.Service;
import school.admin.entities.Department;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface DeptService {

    Department createDept(String name);
    int updateDept(long id,Department department);
    Department deleteDept(long id);
    List<Department> getAllDept();
    Optional<Department> getDeptById(long id);
}
