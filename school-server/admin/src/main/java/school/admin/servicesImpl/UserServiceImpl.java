package school.admin.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.admin.dao.AddressRepository;
import school.admin.dao.DeptRepository;
import school.admin.dao.UserRepository;
import school.admin.entities.Address;
import school.admin.entities.Department;
import school.admin.entities.SystemUser;
import school.admin.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;

    private final DeptRepository deptRepository;

    public UserServiceImpl(UserRepository repository, AddressRepository addressRepository, DeptRepository deptRepository) {
        this.repository = repository;
        this.deptRepository = deptRepository;
    }

    @Override
    public List<SystemUser> getAllUser() {
        List<SystemUser> users = repository.findAll();
        logger.info(users.toString());
        return users;
    }

    @Override
    public SystemUser createUser(SystemUser user) {
        logger.info(String.valueOf(user));
        return repository.save(user);
    }

    @Transactional
    @Override
    public SystemUser updateUser(long id , SystemUser user) {

        Optional<SystemUser> optional = repository.findById(id);

        optional.ifPresent(pUser -> {
            try {
            if(user.getFirstName()!=null){
                pUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName()!= null){
                pUser.setLastName((user.getLastName()));
            }
            if (user.getAddress()!=null){
                Optional<Address> address = Optional.ofNullable(pUser.getAddress());
                address.ifPresentOrElse(a->{
                    pUser.getAddress().setCity(user.getAddress().getCity());
                    pUser.getAddress().setPinCode(user.getAddress().getPinCode());
                    pUser.getAddress().setState(user.getAddress().getState());
                },()-> pUser.setAddress(user.getAddress()));

            }
            if(user.getDepartment()!=null){
                Set<Department> departments = new HashSet<>();
                user.getDepartment().forEach(dept->{
                    Optional<Department> department =deptRepository.findByName(dept.getName());
                    department.ifPresentOrElse(
                            departments::add, ()->{
                               deptRepository.save(dept);
                               departments.add(dept);
                            }
                    );
                });
                pUser.setDepartment(departments);
            }
                repository.save(pUser);
            }catch (RuntimeException e){
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        });
        return optional.orElseThrow(()->new RuntimeException("User Not Updated"));
    }

    @Override
    public int deleteUser(long id) {
        try {
            repository.deleteById(id);
            return 1;
        }catch (RuntimeException e){
            logger.info(e.getMessage());
            return 0;
        }
    }

    @Override
    public SystemUser getUserById(long id) {

        try {
            Optional<SystemUser> user = repository.findById(id);
            return user.get();
        }catch (RuntimeException e){
            throw new UsernameNotFoundException(e.getMessage());
        }

    }
}
