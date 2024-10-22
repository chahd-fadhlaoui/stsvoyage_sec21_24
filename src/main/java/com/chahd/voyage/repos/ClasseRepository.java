package com.chahd.voyage.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.chahd.voyage.entities.Classe;
@RepositoryRestResource(path = "cl")
@CrossOrigin(origins = "http://localhost:4200/")
public interface ClasseRepository extends JpaRepository<Classe, Long> {

}
