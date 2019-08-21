package com.example.newpropreserver1.controller;


import com.example.newpropreserver1.entity.Project;
import com.example.newpropreserver1.service.ServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class ControllerProject {

    @Autowired
    public ServiceProject serviceProject;

    @GetMapping(value="/project")
    private ResponseEntity<List<Project>> findAll(){
        return new ResponseEntity<List<Project>>(serviceProject.findAll(), HttpStatus.OK);
    }

    @GetMapping(value ="/project/{id}")
    private ResponseEntity<Project> findAllById(@PathVariable (value="id") long id){
        Project project=serviceProject.findAllById(id);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }


    @PostMapping(value="project")
    private ResponseEntity<Project> save(@RequestBody Project project){
        Project projectPost=serviceProject.save(project);
        return new ResponseEntity<Project>(projectPost,HttpStatus.OK);
    }


    @DeleteMapping(value = "/project/{id}")
    private ResponseEntity<Project> deleteProject(@PathVariable (value="id") long id){
        Project projectDelete=serviceProject.findAllById(id);
        serviceProject.delete(projectDelete);
        return new ResponseEntity<Project>(projectDelete, HttpStatus.OK);
    }

    @PutMapping(value="/project/{id}")
    private ResponseEntity<Project>  putProject(@PathVariable(value="id") long id ,@RequestBody Project project){
           Project projectPut=serviceProject.findAllById(id);
           projectPut.setName(project.getName());
           projectPut.setTheme(project.getTheme());
           projectPut.setEmployees(project.getEmployees());
           serviceProject.save(projectPut);
           return new ResponseEntity<Project>(projectPut,HttpStatus.OK);
    }




}
