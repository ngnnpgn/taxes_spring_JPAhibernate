package cm.ngnkm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cm.ngnkm.dao.EntrepriseRepository;
import cm.ngnkm.entities.Entreprise;

@Controller
public class TaxeControler {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	/*retourne une vue de nom entreprise - affiche les entreprises */
	@RequestMapping(value="/entreprises", method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="motCle", defaultValue="")String m,
			@RequestParam(name="page", defaultValue="0")int p, 
			@RequestParam(name="size", defaultValue="4")int s) {
		
		Page<Entreprise> pageEntreprises = entrepriseRepository.chercher("%"+m+ "%", new PageRequest(p, s));
		model.addAttribute("listeEntreprises", pageEntreprises.getContent());
		int[] pages = new int[pageEntreprises.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", m);
		return "entreprises";	
	}
	
	@RequestMapping(value="/formEntreprise")
	public String form(Model model) {	
		model.addAttribute("entreprise", new Entreprise());
		return "formEntreprise";
		
	}
	
	@RequestMapping(value="/saveEntreprise")
	public String save(Model model, Entreprise e) {	
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
		
	}
	
}
