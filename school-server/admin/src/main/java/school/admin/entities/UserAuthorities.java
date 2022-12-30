package school.admin.entities;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthorities implements GrantedAuthority {

    private String authorities;

    @Override
    public String getAuthority() {
        return this.authorities;
    }
}
