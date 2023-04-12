package fr.univrouen.stb23v1.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetController {
	@GetMapping("/resume")
	public String getListRSSinXML() {
	return "Envoi de la liste des STB";
	}
	@GetMapping("/stbid")
	public String getRSSinXML(
	@RequestParam(value = "id") String texte) {
	return ("Détail de la STB n°" + texte);
	}
	
	@GetMapping("/test")
	public String gettest(
	@RequestParam(value="id") int id, @RequestParam(value="titre") String texte)
   {
	return ("Test : \r\n"
			+ "id = " +id + "\r\n"
			+ "titre = " + texte);
	}
	
	

}
