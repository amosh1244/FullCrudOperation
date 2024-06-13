package com.CrudDemo.Controller;

import com.CrudDemo.Entity.Employee;
import com.CrudDemo.PayLoad.EmployeeDto;
import com.CrudDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        EmployeeDto dto = employeeService.save(employeeDto);
        return new ResponseEntity<EmployeeDto>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Post is Deleted !!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id){
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
       EmployeeDto dto = employeeService.updateEmployee(id, employeeDto);
       return new ResponseEntity<EmployeeDto>(dto, HttpStatus.OK);
   }

}
