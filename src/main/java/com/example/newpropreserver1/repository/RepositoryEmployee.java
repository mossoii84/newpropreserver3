package com.example.newpropreserver1.repository;

import com.example.newpropreserver1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositoryEmployee extends JpaRepository<Employee,Long> {

        List<Employee> findAll();
        Employee findAllById(long id);

        Employee save(Employee employee);


       void delete(Employee employee);
}
