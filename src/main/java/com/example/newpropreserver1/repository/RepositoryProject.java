package com.example.newpropreserver1.repository;
import com.example.newpropreserver1.entity.Project;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositoryProject  extends JpaRepository<Project,Long> {

    List<Project> findAll();
    Project findAllById(long id);

    Project save(Project project);

    void delete(Project project);

}
