package school.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.admin.AdminService;
import school.admin.AuthUserDetailsService;
import school.admin.entities.SystemUser;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private AuthUserDetailsService userDetailsService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody SystemUser user){
        service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUserByUsername(@Param("username") String username){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userDetailsService.loadUserByUsername(username));
    }
}
