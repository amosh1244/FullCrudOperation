package com.CrudDemo.Service;

import com.CrudDemo.Entity.Employee;
import com.CrudDemo.Exception.ResourceNotFound;
import com.CrudDemo.PayLoad.EmployeeDto;
import com.CrudDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto dto = mapToDto(savedEmployee);
        return dto;

    }

    @Override
    public EmployeeDto getEmployeeById(long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Id not found by this Employee")
        );


        return mapToDto(employee);
    }


    private EmployeeDto mapToDto(Employee savedEmployee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(savedEmployee.getId());
        employeeDto.setName(savedEmployee.getName());
        employeeDto.setGmail(savedEmployee.getGmail());
        employeeDto.setPhone(savedEmployee.getPhone());
        return employeeDto;
    }

    Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setGmail(employeeDto.getGmail());
        employee.setPhone(employeeDto.getPhone());
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Id Not Found By Employee : " + id)
        );

        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {

            Employee employee = employeeRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFound("Id not found by this Employee")
            );

            employee.setId(employeeDto.getId());
            employee.setName(employeeDto.getName());
            employee.setGmail(employeeDto.getGmail());
            employee.setPhone(employeeDto.getPhone());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto dto = mapToDto(savedEmployee);

        return dto;
    }


}
