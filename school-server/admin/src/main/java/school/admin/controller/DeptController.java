package school.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.admin.dto.ResponseHandler;
import school.admin.entities.Department;
import school.admin.services.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/get")
    public ResponseEntity<Object> getAllDept(){
        return ResponseHandler
                .generateResponse("Department list",
                        "Success",
                        HttpStatus.OK,
                        deptService.getAllDept());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getDeptById(@PathVariable Long id){
        return ResponseHandler.generateResponse(
                "Department",
                "Success",
                HttpStatus.OK,
                deptService.getDeptById(id)
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createDept(@RequestBody String name){
        return ResponseHandler.generateResponse(
                "Department created",
                "Success",
                HttpStatus.CREATED,
                deptService.createDept(name)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDeptById(@RequestBody Department department, @PathVariable Long id){
        return ResponseHandler.generateResponse(
                "Department updated",
                "Success",
                HttpStatus.OK,
                deptService.updateDept(id, department)
        );
    }
}
