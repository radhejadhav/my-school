package school.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import school.admin.dao.DeptRepository;
import school.admin.dao.RoleRepository;
import school.admin.entities.Department;
import school.admin.entities.Role;
import school.admin.entities.RolesEnum;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
