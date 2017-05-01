package cm.ngnkm.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe {

	public IR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IR(String titre, Date dataTaxe, double montant, Entreprise entreprise) {
		super(titre, dataTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}
	
	

}
