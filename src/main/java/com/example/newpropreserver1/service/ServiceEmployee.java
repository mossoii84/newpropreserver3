package com.example.newpropreserver1.service;

import com.example.newpropreserver1.entity.Employee;
import com.example.newpropreserver1.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmployee {

    @Autowired
    public RepositoryEmployee repositoryEmployee;


    public List<Employee> findAll(){return repositoryEmployee.findAll();}

    public Employee  findAllById(long id){return repositoryEmployee.findAllById(id);}

    public Employee save( Employee employee){ return repositoryEmployee.save(employee);}

    public void delete(Employee employee){ repositoryEmployee.delete(employee);}



}
