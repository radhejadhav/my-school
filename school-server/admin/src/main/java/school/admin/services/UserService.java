package school.admin.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import school.admin.entities.SystemUser;

import java.util.List;

public interface UserService {

    List<SystemUser> getAllUser();
    SystemUser createUser(SystemUser user);
    SystemUser updateUser(long id, SystemUser userDetails) throws UsernameNotFoundException;
    int deleteUser(long id);
    SystemUser getUserById(long id);
}
