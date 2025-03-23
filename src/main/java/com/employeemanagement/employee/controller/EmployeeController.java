package com.employeemanagement.employee.controller;

import com.employeemanagement.employee.dto.EmployeeDto;
import com.employeemanagement.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employe")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;



    @PostMapping
    public EmployeeDto newEmployé(@RequestBody EmployeeDto employéDto) {
        return service.newEmployé(employéDto);
    }



    @GetMapping("/get")
    public List<EmployeeDto> getEmployé() {
        return service.getEmployé();
    }



    @GetMapping("/id/{id}")
    public EmployeeDto getEmployéById(@PathVariable Long id) {
        return service.getEmployéById(id);
    }



    @PutMapping("/put/{id}")
    public EmployeeDto updateEmployé(@RequestBody EmployeeDto employéDto, @PathVariable Long id) {
        return service.updateEmployé(employéDto, id);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteEmployé(@PathVariable Long id) {
        service.deleteEmployé(id);
    }

}

