package com.chahd.voyage.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chahd.voyage.entities.Voyage;
import com.chahd.voyage.service.VoyageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoyageRESTController {
	@Autowired
	VoyageService voyageService;

	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Voyage> getAllVoyages() {
	    return voyageService.getAllVoyages();
	}

	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Voyage getVoyageById(@PathVariable("id") Long id) {  
	    return voyageService.getVoyage(id);
	}

	@RequestMapping(value="/addvoya",method = RequestMethod.POST)
	public Voyage createVoyage(@RequestBody Voyage voyage) {
	    return voyageService.saveVoyage(voyage);
	}

	@RequestMapping(value="/updatevoya",method = RequestMethod.PUT)
	public Voyage updateVoyage(@RequestBody Voyage voyage) {
	    return voyageService.updateVoyage(voyage);
	}

	@RequestMapping(value="/delvoya/{id}",method = RequestMethod.DELETE)
	public void deleteVoyage(@PathVariable("id") Long id)
	{
	    voyageService.deleteVoyageById(id);
	}

	@RequestMapping(value="/voyagescl/{idCl}", method = RequestMethod.GET)
	public List<Voyage> getVoyagesByClId(@PathVariable("idCl") Long idCl) {
	    return voyageService.findByClasseIdCl(idCl);
	}
	@RequestMapping(value="/voyagesByName/{nom}",method = RequestMethod.GET)
	public List<Voyage> findByNomVoyageContains(@PathVariable("nom") String nom) {
	return voyageService.findByNomVoyageContains(nom);
	}




	

}

