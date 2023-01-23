//package school.admin.dto;
//
//import school.admin.entities.Role;
//import school.admin.entities.SystemUser;
//
//import java.util.Set;
//
//public class UserBuilder {
//
//    SystemUser user = new SystemUser();
//
//    public static UserBuilder getBuilder(SystemUser user){
//       return new UserBuilder(user);
//    }
//    public static UserBuilder getBuilder(){
//       return new UserBuilder();
//    }
//
//    public UserBuilder() {
//    }
//
//    public UserBuilder(SystemUser user) {
//        this.user = user;
//    }
//
//    public UserBuilder setUsername(String username){
//        this.user.setUsername(username);
//        return this;
//    }
//    public UserBuilder setPassword(String password){
//        this.user.setPassword(password);
//        return this;
//    }
//    public UserBuilder setRoles(Set<Role> roles){
//        this.user.setRoles(roles);
//        return this;
//    }
//    public SystemUser build(){
//        return this.user;
//    }
//}
