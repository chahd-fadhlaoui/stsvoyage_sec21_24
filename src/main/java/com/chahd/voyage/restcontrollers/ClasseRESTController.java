package com.chahd.voyage.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chahd.voyage.entities.Classe;
import  com.chahd.voyage.repos.ClasseRepository;
@RestController
@RequestMapping("/api/cl")
@CrossOrigin("*")
public class ClasseRESTController {
	
	
	@Autowired
	ClasseRepository ClasseRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Classe> getAllClasses()
	{
	return ClasseRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Classe getClasseById(@PathVariable("id") Long id) {
	return ClasseRepository.findById(id).get();
	}

}
