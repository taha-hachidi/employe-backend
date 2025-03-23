package com.employeemanagement.employee.service;

import com.employeemanagement.employee.dto.EmployeeDto;
import com.employeemanagement.employee.model.Employee;
import com.employeemanagement.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto newEmployé(EmployeeDto employéDto) {
        Employee employé = new Employee();
        employé = modelMapper.map(employéDto, Employee.class);
        repository.save(employé);
        return employéDto;
    }

    @Override
    public List<EmployeeDto> getEmployé() {
        List<EmployeeDto> employéDtos = new ArrayList<>();
        List<Employee> employés = repository.findAll();
        for (Employee employé : employés){
            EmployeeDto employéDto = modelMapper.map(employé, EmployeeDto.class);
            employéDtos.add(employéDto);
        }
        return employéDtos;
    }

    @Override
    public EmployeeDto getEmployéById(Long id) {
        Optional<Employee> employé = repository.findById(id);
        EmployeeDto employéDto = modelMapper.map(employé, EmployeeDto.class);
        return employéDto;
    }

    @Override
    public EmployeeDto updateEmployé(EmployeeDto employéDto, Long id) {
        Employee employé = new Employee();
        employé = modelMapper.map(employéDto, Employee.class);
        Employee finalEmployee = employé;
        repository.findById(id).map(ow ->{
            ow.setName(finalEmployee.getName());
            ow.setEmail(finalEmployee.getEmail());
            ow.setAge(finalEmployee.getAge());
            ow.setSalary(finalEmployee.getSalary());


            return repository.save(ow);
        } );
        return employéDto;
    }

    @Override
    public void deleteEmployé(Long id) {
        repository.deleteById(id);
    }
}
