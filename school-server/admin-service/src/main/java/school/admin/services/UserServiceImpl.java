package school.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import school.admin.entities.User;
import school.admin.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> opt = repository.findUserByEmail(email);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("User with email: " +email +" not found !");
        else {
            User user = opt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role))
                            .collect(Collectors.toSet())
            );
        }
    }

    @Override
    public Integer saveUser(User user) {
        String passwd= user.getPassword();
        String encodedPasswod = encoder.encode(passwd);
        user.setPassword(encodedPasswod);
        user = repository.save(user);
        return user.getId();
    }
}
