package school.admin.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.admin.dao.UserRepository;
import school.admin.entities.SystemUser;
import school.admin.entities.SystemUserDetails;
import school.admin.services.AdminService;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<SystemUser> getAllUser() {
        return repository.findAll();
    }

    @Override
    public SystemUser createUser(SystemUser user) {
        return repository.save(user);
    }

    @Override
    public SystemUser updateUser(SystemUserDetails userDetails, Long id) throws UserPrincipalNotFoundException {

        SystemUser user = null;
        Optional<SystemUser> userData = repository.findById(id);
        if(userData.isPresent()){
            user = userData.get();
        }else {
            throw  new UserPrincipalNotFoundException("User account not found");
        }
        user.setUserDetails(userDetails);
        repository.save(user);
        return user;
    }
}
