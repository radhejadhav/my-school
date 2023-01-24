package school.admin.entities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SystemUserBuilder {

    private SystemUser user;

    public SystemUserBuilder(SystemUser user) {
        this.user = user;
    }

    public SystemUserBuilder setId(long id){
        this.user.setId(id);
        return this;
    }
    public SystemUserBuilder setUsername(String username){
        this.user.setUsername(username);
        return this;
    }
    public SystemUserBuilder setPassword(String password){
        this.user.setPassword(password);
        return this;
    }
    public SystemUserBuilder setFirstName(String firstName){
        this.user.setFirstName(firstName);
        return this;
    }
    public SystemUserBuilder setLastName(String lasttName){
        this.user.setLastName(lasttName);
        return this;
    }
    public SystemUserBuilder setRoles(String[] rolesArry){
        Set<Role> roles = new HashSet<>();
        Arrays.stream(rolesArry).forEach(role->{
            switch (role) {
                case "admin" -> {
                    Role admin = new Role();
                    admin.setName(RolesEnum.ROLE_ADMIN);
                    admin.setId(1);
                    roles.add(admin);
                }
                case "mod" -> {
                    Role moderator = new Role();
                    moderator.setName(RolesEnum.ROLE_MODERATOR);
                    moderator.setId(2);
                    roles.add(moderator);
                }
                default -> {
                    Role userRole = new Role();
                    userRole.setName(RolesEnum.ROLE_USER);
                    userRole.setId(3);
                    roles.add(userRole);
                }
            }
        });
        this.user.setRoles(roles);
        return this;
    }

    public SystemUser build(){
        return user;
    }

}
