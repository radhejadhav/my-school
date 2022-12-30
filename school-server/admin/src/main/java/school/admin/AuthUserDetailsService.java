package school.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import school.admin.dao.UserRepository;
import school.admin.entities.SystemUser;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUser> user = userRepository.findSystemUserByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Username Not Found");
        }
        SystemUser user1 = user.get();
        return User
                .withUsername(user1.getUsername())
                .password(user1.getPassword())
                .roles(String.join(", ROLE_", user1.getRoles())).build();
    }
}
