package school.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import school.admin.dto.ResponseHandler;
import school.admin.entities.SystemUser;
import school.admin.services.UserService;

@RestController
@RequestMapping("/users")
@EnableTransactionManagement
public class AdminController {

    private final UserService adminService;

    public AdminController(UserService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/find-all")
    public ResponseEntity<Object> allUsers() {
        return ResponseHandler
                .generateResponse("users list",
                        HttpStatus.OK.toString(),
                        HttpStatus.OK,
                        adminService.getAllUser()
                );
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findByusername(@PathVariable Long id){
        return ResponseHandler
                .generateResponse("users details",
                        "Success",
                        HttpStatus.OK,
                        adminService.getUserById(id)
                );
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Object> updateUserById(@RequestBody SystemUser userDetails, @PathVariable Long id) {
            return ResponseHandler.generateResponse(
                    "updated user",
                    HttpStatus.ACCEPTED.toString(),
                    HttpStatus.ACCEPTED,
                    adminService.updateUser(id, userDetails )
            );
    }

    @PutMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id){
        return ResponseHandler.generateResponse(
                "user deleted",
                "Success",
                HttpStatus.OK,
                id
        );
    }
}
