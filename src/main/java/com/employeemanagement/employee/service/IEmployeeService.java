package com.employeemanagement.employee.service;
import com.employeemanagement.employee.dto.EmployeeDto;


import java.util.List;

public interface IEmployeeService {
     EmployeeDto newEmployé(EmployeeDto employéDto);
    List<EmployeeDto> getEmployé();
    EmployeeDto getEmployéById(Long id);
    EmployeeDto updateEmployé(EmployeeDto employéDto, Long id);
    void deleteEmployé(Long id);
}
