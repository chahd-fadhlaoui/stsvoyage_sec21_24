package com.chahd.voyage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.chahd.voyage.entities.Classe;
import com.chahd.voyage.entities.Voyage;
import com.chahd.voyage.repos.VoyageRepository;

@Service

public class VoyageServiceImpl implements VoyageService{

	@Autowired
	VoyageRepository voyageRepository;
	@PreAuthorize("hasAuthority('ADMIN')")

	@Override
	public Voyage saveVoyage(Voyage v) {
	    return voyageRepository.save(v);
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
	    return voyageRepository.save(v);
	}

	@Override
	public void deleteVoyage(Voyage v) {
	    voyageRepository.delete(v);
	}

	@Override
	public void deleteVoyageById(Long id) {
	    voyageRepository.deleteById(id);
	}

	@Override
	public Voyage getVoyage(Long id) {
	    return voyageRepository.findById(id).get();
	}

	@Override
	public List<Voyage> getAllVoyages() {
	    return voyageRepository.findAll();
	}

	@Override
	public List<Voyage> findByNomVoyage(String nom) {
		return voyageRepository.findByNomVoyage(nom);
	}

	@Override
	public List<Voyage> findByNomVoyageContains(String nom) {
		return voyageRepository.findByNomVoyageContains(nom);
	}

	@Override
	public List<Voyage> findByNomPrix(String nom, Double prix) {
		return voyageRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Voyage> findByClasse(Classe classe) {
		return voyageRepository.findByClasse(classe);
	}

	@Override
	public List<Voyage> findByClasseIdCl(Long id) {
		return voyageRepository.findByClasseIdCl(id);
	}

	@Override
	public List<Voyage> findByOrderByNomVoyageAsc() {
		return voyageRepository.findByOrderByNomVoyageAsc();
	}

	@Override
	public List<Voyage> trierVoyagesNomsPrix() {
		return voyageRepository.trierVoyagesNomsPrix();
	}


}
