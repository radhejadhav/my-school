package school.admin.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import school.admin.AuthUserDetailsService;


@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private AuthUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user;

        try {
            user = userDetailsService.loadUserByUsername(name);
        }catch (UsernameNotFoundException e){
            throw new BadCredentialsException("Invalid login");
        }
        if(password.equals(user.getPassword())){
            System.out.println("success");
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
            token.setDetails(authentication.getDetails());
            return token;
        }else throw new BadCredentialsException("Invalid Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
