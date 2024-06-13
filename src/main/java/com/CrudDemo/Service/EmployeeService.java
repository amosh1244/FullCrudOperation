package com.CrudDemo.Service;

import com.CrudDemo.PayLoad.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto save(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(long id);
    public void deleteEmployeeById(long id);
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto);

}
