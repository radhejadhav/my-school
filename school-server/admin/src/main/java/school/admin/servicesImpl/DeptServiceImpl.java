package school.admin.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.admin.dao.DeptRepository;
import school.admin.entities.Department;
import school.admin.services.DeptService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Department createDept(String name) {
        return deptRepository.save(new Department(name));
    }

    @Override
    public int updateDept(long id, Department department) {
        return deptRepository.updateDeptById(id, department.getName());
    }

    @Override
    public Department deleteDept(long id) {
        deptRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Department> getAllDept() {
        return deptRepository.findAll();
    }

    @Override
    public Optional<Department> getDeptById(long id) {
        return deptRepository.findById(id);
    }
}
