package cm.ngnkm.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cm.ngnkm.dao.EntrepriseRepository;
import cm.ngnkm.dao.TaxeRepository;
import cm.ngnkm.entities.Entreprise;

@Controller
public class TaxeControler {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	
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
	public String save(Model model, @Valid Entreprise e, BindingResult bindingResult) {	
		
		if(bindingResult.hasErrors())
			return "formEntreprise";
		
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
		
	}
	
	@RequestMapping(value="/taxes")
	public String taxe(Model model, Long code) {	
		
		Entreprise e = new Entreprise(); 
		e.setCode(code);
		model.addAttribute("taxes", taxeRepository.findByEntreprise(e));
		return "taxes";
		
	}
	
}
