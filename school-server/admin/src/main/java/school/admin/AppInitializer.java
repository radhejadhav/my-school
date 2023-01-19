package school.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import school.admin.dao.DeptRepository;
import school.admin.dao.RoleRepository;
import school.admin.entities.Department;
import school.admin.entities.Role;
import school.admin.entities.RolesEnum;
import school.admin.services.DeptService;

import java.util.Set;

@Component
public class AppInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DeptService deptService;

    @EventListener(ApplicationReadyEvent.class)
    public void afterInit(){

        Role role1 = new Role(RolesEnum.ROLE_USER);
        Role role2 = new Role(RolesEnum.ROLE_ADMIN);
        Role role3 = new Role(RolesEnum.ROLE_MODERATOR);
        Set<Role> roles = Set.of(role1, role2, role3);

        for(Role r: roles){
            roleRepository.save(r);
        }

        Department department1 = new Department("Engineering");
        Department department2 = new Department("Digital");
        Department department3 = new Department("Admin");
        Department department4 = new Department("Human Resource");

        Set<Department> departments = Set.of(department1,department2,department3,department4);

        for(Department d: departments){
            deptService.createDept(d.getName());
        }
    }
}
