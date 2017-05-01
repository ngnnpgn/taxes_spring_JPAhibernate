package cm.ngnkm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING, length=3)
public abstract class Taxe implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private Date dataTaxe;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_ENTREPRISE")
	private Entreprise entreprise;
	public Taxe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxe(String titre, Date dataTaxe, double montant, Entreprise entreprise) {
		super();
		this.titre = titre;
		this.dataTaxe = dataTaxe;
		this.montant = montant;
		this.entreprise = entreprise;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDataTaxe() {
		return dataTaxe;
	}
	public void setDataTaxe(Date dataTaxe) {
		this.dataTaxe = dataTaxe;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	

}

