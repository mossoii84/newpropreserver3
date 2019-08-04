package com.example.newpropreserver1.controller;

import com.example.newpropreserver1.entity.Employee;
import com.example.newpropreserver1.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerEmployee {

    @Autowired
    public ServiceEmployee serviceEmployee;

    @GetMapping(value = "/employee")
    private ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<List<Employee>>(serviceEmployee.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{id}")
    private ResponseEntity<Employee> findAllById(@PathVariable (value = "id") long id ){
        Employee employeeById=serviceEmployee.findAllById(id);
        return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    private ResponseEntity<Employee> save(@RequestBody Employee employee){
        Employee employeePost=serviceEmployee.save(employee);
        return new ResponseEntity<Employee>(employeePost,HttpStatus.OK);
    }


    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Employee>deleteEmployee(@PathVariable (value="id") long id){
        Employee employee=serviceEmployee.findAllById(id); //тут get ищем
        serviceEmployee.delete(employee); //тут уже delete  удаляем
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/employee/{id}")
    private ResponseEntity<Employee> put(@PathVariable (value = "id") Long id , @RequestBody Employee employee) {
     Employee employeePut=serviceEmployee.findAllById(id);
        employeePut.setName(employee.getName());
        employeePut.setAge(employee.getAge());
     serviceEmployee.save(employeePut);
     return new ResponseEntity<Employee>(employeePut,HttpStatus.OK);
    }



}
