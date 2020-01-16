package com.employeeApplication.employee.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired    //to provide the runtime object
    private EmployeeService employeeService;

    @GetMapping("status")
    public String status(){

        return "{\"status:\" \"Webservice is Up!\"}";
    }

    @PostMapping
    public ResponseEntity registerEmployee(@RequestBody(required = true) Employee employee){

        //System.out.println("Employee Name: "+ employee.getEmp_name());
        employeeService.registerEmployee(employee);
        return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){

       /* List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmp_id(137);
        employee.setEmp_name("Sunidhi Jain");
        employee.setDomain("Digital");
        employee.setDesignation("Project Engineer");
        employee.setEmail_id("sunidhi@gmail.com");

        employeeList.add(employee);
        employeeList.add(employee);*/
       List <Employee> employeeList= employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);

    }

    @GetMapping("{emp_id}")

    public ResponseEntity<Employee> getEmployee(@PathVariable(value="emp_id")  Integer empId){
        /*
        Employee employee = new Employee();
        employee.setEmp_id(321);
        employee.setEmp_name("Neha Bara");
        employee.setDomain("Digital");
        employee.setDesignation("Project Engineer");
        employee.setEmail_id("neha@gmail.com");  */

        Employee employee= employeeService.getEmployee(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("{emp_id}")

    public ResponseEntity updateEmployee(@PathVariable(value="emp_id")  Integer empId, @RequestBody(required = true) Employee employee){
        //System.out.println("API updated...");

        employeeService.update(empId, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{emp_id}")

        public ResponseEntity deleteEmployee(@PathVariable(value="emp_id") Integer empId){
        //System.out.println("Data deleted...");

        employeeService.delete(empId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
