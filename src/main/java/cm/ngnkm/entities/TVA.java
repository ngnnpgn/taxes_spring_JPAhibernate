package cm.ngnkm.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe {

	public TVA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TVA(String titre, Date dataTaxe, double montant, Entreprise entreprise) {
		super(titre, dataTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}
	
}
