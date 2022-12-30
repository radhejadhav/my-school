package school.admin;

import org.springframework.stereotype.Service;
import school.admin.entities.SystemUser;

import java.util.List;

public interface AdminService {

    List<SystemUser> getAllUser();
    SystemUser createUser(SystemUser user);
}
