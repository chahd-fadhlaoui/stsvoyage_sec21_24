package com.chahd.voyage;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chahd.voyage.entities.Classe;
import com.chahd.voyage.entities.Voyage;
import com.chahd.voyage.repos.VoyageRepository;

@SpringBootTest
class VoyageApplicationTests {

	@Autowired
	private VoyageRepository voyageRepository;
	@Test
	public void testCreateVoyage() {
		Voyage voya = new Voyage("turquie",5000.500,new Date());
      voyageRepository.save(voya);  
	}
	 @Test
	 public void testFindVoyage()
	 {
		 Voyage voya = voyageRepository.findById(1L).get();
	 System.out.println(voya);
	 }
	 @Test
	 public void testUpdateVoyage()
	 {
		 Voyage voya = voyageRepository.findById(1L).get();
	 voya.setPrixVoyage(2000.0);
	 voyageRepository.save(voya);
	 }
	 @Test
	 public void testDeleteVoyage()
	 {
		 voyageRepository.deleteById(1L);;
	 }
	 @Test
	 public void testListerTousVoyages()
	 {
	    List<Voyage> voya =voyageRepository.findAll();
	     for (Voyage v : voya)
	         System.out.println(v);
	       
	     
	 }
	 @Test
	 public void testFindVoyageByNom()
	 {
		List< Voyage> voya= voyageRepository.findByNomVoyage("maldive");
		for (Voyage v : voya)
	         System.out.println(v);
	       
	 }
	 @Test
	 public void testFindVoyageByNomContains()
	 {
		List< Voyage> voya= voyageRepository.findByNomVoyageContains("V");
		for (Voyage v : voya)
	         System.out.println(v);
	       
	 }
	 @Test
	 public void testFindByNomPrix() {
	     List<Voyage> voya= voyageRepository.findByNomPrix("turquie", 1000.0);
	     for (Voyage v : voya) {
	         System.out.println(v);
	     }
	 }
	 @Test
	 public void testFindByClasse() {
	     Classe cl = new Classe();
	     cl.setIdCl(2L);
	     
	     List<Voyage> voya= voyageRepository.findByClasse(cl);
	     
	     for (Voyage v : voya) {
	         System.out.println(v);
	     }
	 }
	 @Test
	 public void findByClasseIdCl() {
	     List<Voyage> voya = voyageRepository.findByClasseIdCl(3L);
	     for (Voyage v : voya) {
	         System.out.println(v);
	     }
	 }
	 @Test
	 public void testFindByOrderByNomVoyageAsc() {
	     List<Voyage> voya = voyageRepository.findByOrderByNomVoyageAsc();
	     for (Voyage v : voya) {
	         System.out.println(v);
	     }
	 }
	 @Test
	 public void testTrierVoyagesNomsPrix()
	 {
	     List<Voyage> voya= voyageRepository.trierVoyagesNomsPrix();
	     for (Voyage v : voya)
	     {
	         System.out.println(v);
	     }
	 }

	 
	 










}

