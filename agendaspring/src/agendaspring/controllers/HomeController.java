package agendaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String homeSeila() {
		System.out.println("Chamou o método da home! ");
		return "home";
	}

}
