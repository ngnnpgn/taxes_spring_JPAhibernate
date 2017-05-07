package cm.ngnkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.ngnkm.entities.Entreprise;
import cm.ngnkm.entities.Taxe;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {
	
	public List<Taxe> findByEntreprise(Entreprise e) ;
		

}
