package school.admin.services;

import org.springframework.stereotype.Service;
import school.admin.entities.SystemUser;
import school.admin.entities.SystemUserDetails;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface AdminService {

    List<SystemUser> getAllUser();
    SystemUser createUser(SystemUser user);


    SystemUser updateUser(SystemUserDetails userDetails, Long id) throws UserPrincipalNotFoundException;
}
