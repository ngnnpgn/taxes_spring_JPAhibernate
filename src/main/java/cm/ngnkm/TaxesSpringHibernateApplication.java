package cm.ngnkm;


import java.util.Date;

import cm.ngnkm.dao.EntrepriseRepository;
import cm.ngnkm.dao.TaxeRepository;
import cm.ngnkm.entities.Entreprise;
import cm.ngnkm.entities.IR;
import cm.ngnkm.entities.TVA;
import cm.ngnkm.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class TaxesSpringHibernateApplication implements CommandLineRunner {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;

	public static void main(String[] args) {
		
		SpringApplication.run(TaxesSpringHibernateApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {	
		
		Entreprise e1 = entrepriseRepository.save(new Entreprise("R1", "r1@gmail.com", "SARL"));
		Entreprise e2 = entrepriseRepository.save(new Entreprise("R2", "r2@gmail.com", "SARL"));
		//TaxeRepository t1 = (TaxeRepository) 
		
		((JpaRepository<Taxe, Long>) taxeRepository).save(new TVA("TVA habitation", new Date(), 900, e1));
		((JpaRepository<Taxe, Long>) taxeRepository).save(new TVA("TVA voiture", new Date(), 400, e1));
		((JpaRepository<Taxe, Long>) taxeRepository).save(new IR("IR 2016", new Date(), 4500, e2));
		((JpaRepository<Taxe, Long>) taxeRepository).save(new IR("TVA habitation", new Date(), 400, e2));
			
		// TODO Auto-generated method stub
		
	}
}

