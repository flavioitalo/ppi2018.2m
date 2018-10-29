package agendaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import agendaspring.daos.ContatoDAO;
import agendaspring.models.Contato;

@Controller
public class ContatoController {
	
	@RequestMapping("/contatos/form")
	public String form() {
		System.out.println("Chamou o form de contatos ");
		return "contatos/form";
	}
	
	//Método de inserir//
	@PostMapping("/contatos")
	public String adicionar(Contato contato ) {
	System.out.println(contato);	
	ContatoDAO dao = new ContatoDAO ();
	dao.inserir(contato);	
		
		return "redirect:contatos";
	}
	
	//Método de listagem//
	@GetMapping("/contatos")   
	public ModelAndView listar() {
		ContatoDAO dao = new ContatoDAO ();
		List<Contato> lista = dao.getLista();
		ModelAndView model = new ModelAndView("contatos/listar");
		model.addObject("contatos", lista);
		return model;
	
	}
	
	@RequestMapping("/contatos/remover")
	public String remover(Contato contato) {
		System.out.println("Chamou o método remover ");
		ContatoDAO dao = new ContatoDAO ();
		dao.remover(contato);
		
		return "redirect:../contatos/";
	}

}
