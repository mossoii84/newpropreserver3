package com.example.newpropreserver1.service;

import com.example.newpropreserver1.entity.Project;
import com.example.newpropreserver1.repository.RepositoryProject;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ServiceProject {

    @Autowired
    public RepositoryProject repositoryProject;


    public List<Project> findAll(){return repositoryProject.findAll();}
    public Project findAllById(long id){return repositoryProject.findAllById(id);}

    public Project save(Project project){return repositoryProject.save(project);}
    public void delete(Project project){ repositoryProject.delete(project);}


}
