package fr.univrouen.stb23v1.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;


import ErrorHandler.ErrorXmlResponse;
import dto.STBXmlResponse;


import model.STB;
import model.STBSummary;
import repositories.STBRepositoryImpl;
import util.TestSTB;

@RestController
public class GetController {

    private final STBRepositoryImpl stbRepo;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GetController.class);
 
    
    @Autowired
    public GetController(STBRepositoryImpl stbRepo) {
        this.stbRepo = stbRepo;
    }
    
    @GetMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<STB>> getSTBSummaryList() {
        List<STB> stbList = stbRepo.findAll();
        List<STB> stbSummaryList = createSTBSummaryList(stbList);
        return ResponseEntity.ok(stbSummaryList);
    }
    
   
    @GetMapping(value = "/stb23/resume", produces = MediaType.TEXT_HTML_VALUE)
    public Model getSTBSummaryListHTML(Model model)  {
       List<STB> stbList = stbRepo.findAll();
        List<STBSummary> stbSummaryList = stbList.stream()
        	    .map(stb -> new STBSummary(stb.getId(), stb.getTitre(), stb.getDescription(), stb.getDate().toString(), stb.getNomEntite()))
        	    .collect(Collectors.toList());
        //LOGGER.info("Contenu de stbSummaryList : {}", stbSummaryList);
        //return stbList;
             
        model.addAttribute("specs", stbSummaryList);
        
        return model;
    }
 


    private List<STB> createSTBSummaryList(List<STB> stbList) {
        List<STB> stbSummaryList = new ArrayList<>();
        for (STB stb : stbList) {
            STB stbSummary = new STB();
            stbSummary.setId(stb.getId());
            stbSummary.setTitre(stb.getTitre());
            stbSummary.setDescription(stb.getDescription());
            stbSummary.setDate(stb.getDate());
            stbSummary.setNomEntite(stb.getNomEntite());
            stbSummaryList.add(stbSummary);
        }
        return stbSummaryList;
    }
    
    @GetMapping(value = "/stb23/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getSTBXML(@PathVariable("id") String id) throws Exception {
        Optional<STB> stbOptional = stbRepo.findById(id);
        
        if (stbOptional.isPresent()) {
            STB stb = stbOptional.get();
            STBXmlResponse response = new STBXmlResponse(stb); 
            
            return ResponseEntity.ok(response);}
            
       else {
            ErrorXmlResponse errorResponse = new ErrorXmlResponse(id, "ERROR"); 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        	
        }
    }

    

    @GetMapping("/stb23/html/{id}")
    public Model getSTBHtml(@RequestParam("id") String id, Model model) {
    	
            // Récupérer la spécification correspondante à l'identifiant
    		Optional<STB> stb = stbRepo.findById(id);
        
            if (stb.isEmpty()) {
            	
            	 model.addAttribute("id", id);
                 model.addAttribute("status", "ERROR");
                 
                 // Renvoyer le nom de la vue (template HTML) pour l'erreur
                 return model;
            }
            // Renvoyer le nom de la vue (template HTML) à afficher
            // return "error";
         else {
        	 
        	  // Ajouter la spécification au modèle pour l'affichage
              model.addAttribute("spec", stb.get());
        	  return model;
        	// return "stb_details";
        }
    }
    
       
    private Optional<STB> getSTBById(String id) {
    	 return stbRepo.findById(id);
    }

    
    @GetMapping(value = "/help")
    public ResponseEntity<String> getInfoHelp() {
        return ResponseEntity.ok(TestSTB.loadFileAide());
    }

   
   
}
