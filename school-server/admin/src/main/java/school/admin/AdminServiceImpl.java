package school.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.admin.dao.UserRepository;
import school.admin.entities.SystemUser;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

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
}
