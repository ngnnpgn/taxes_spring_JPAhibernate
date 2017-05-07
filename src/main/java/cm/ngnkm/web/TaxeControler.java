package cm.ngnkm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cm.ngnkm.dao.EntrepriseRepository;
import cm.ngnkm.entities.Entreprise;

@Controller
public class TaxeControler {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	/*retourne une vue de nom entreprise - affiche les entreprises */
	@RequestMapping(value="/entreprises", method = RequestMethod.GET)
	public String index(Model model) {
		
		List<Entreprise> entreprises = entrepriseRepository.findAll();
		model.addAttribute("listeEntreprises", entreprises);
		return "entreprises";
		
	}
}
