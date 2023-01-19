package school.admin.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import school.admin.dao.RoleRepository;
import school.admin.entities.Role;
import school.admin.services.RoleService;

import java.util.Set;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(String name) {
        return null;
    }

    @Override
    public Role updateRole(int id, String name) {
        return null;
    }

    @Override
    public Role deleteRole(int id) {
        return null;
    }

    @Override
    public Set<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        return null;
    }
}
