package com.chahd.voyage.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity


public class Classe {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idCl;
	private String nomCl;
	private String descriptionCl;
	
	@OneToMany(mappedBy = "classe")
	@JsonIgnore
	
	private List<Voyage> voyage;
	
	
	
	

	public Classe() {
		super();
	}
	public Long getIdCl() {
		return idCl;
	}
	public void setIdCl(Long idCl) {
		this.idCl = idCl;
	}
	public String getNomCl() {
		return nomCl;
	}
	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}
	public String getDescriptionCl() {
		return descriptionCl;
	}
	public void setDescriptionCl(String descriptionCl) {
		this.descriptionCl = descriptionCl;
	}
	public List<Voyage> getVoyage() {
		return voyage;
	}
	public void setVoyage(List<Voyage> voyage) {
		this.voyage = voyage;
	}
	
	
	

}

