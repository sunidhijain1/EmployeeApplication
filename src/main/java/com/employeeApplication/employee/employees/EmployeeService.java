package com.employeeApplication.employee.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void registerEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int empId){
        Optional<Employee> employee =employeeRepository.findById(empId);  //what is optional
        return employee.get();
    }

    public void update(int empId,Employee employee){
        employee.setEmp_id(empId);
        employeeRepository.save(employee);

    }
    public void delete(int empId){
        employeeRepository.deleteById(empId);
    }
}
