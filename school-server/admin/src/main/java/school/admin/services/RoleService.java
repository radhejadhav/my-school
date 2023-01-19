package school.admin.services;

import school.admin.entities.Role;

import java.util.Set;

public interface RoleService {

    Role createRole(String name);
    Role updateRole(int id, String name);
    Role deleteRole(int id);
    Set<Role> getAllRoles();
    Role getRoleById(int id);
}
