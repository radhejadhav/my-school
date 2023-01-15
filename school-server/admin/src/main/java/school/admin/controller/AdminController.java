package school.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import school.admin.dto.ResponseHandler;
import school.admin.entities.SystemUserDetails;
import school.admin.exceptions.CustomException;
import school.admin.services.AdminService;
import school.admin.servicesImpl.UserDetailsServiceImpl;
import school.admin.entities.SystemUser;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/users")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity<Object> allAccess() {
        return ResponseHandler
                .generateResponse("users list",
                        HttpStatus.OK.toString(),
                        HttpStatus.OK,
                        adminService.getAllUser());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findByusername(@PathVariable Long id){
        return null;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUserByUsername(@RequestBody SystemUserDetails userDetails, @PathVariable Long id) throws CustomException {
        try {
            return ResponseHandler.generateResponse(
                    "updated user",
                    HttpStatus.ACCEPTED.toString(),
                    HttpStatus.ACCEPTED,
                    adminService.updateUser(userDetails, id)
            );
        } catch (UserPrincipalNotFoundException e) {
            throw new CustomException(e.getMessage());
        }
    }

    @GetMapping("/roles")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
