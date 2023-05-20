package fr.univrouen.stb23v1.controllers;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import ErrorHandler.ErrorXmlResponse;
import dto.STBXmlResponse;
import dto.STBXmlResponseInsert;
import exceptions.STBInvalidException;
import model.STB;
import repositories.STBRepositoryImpl;
import services.STBService;
import util.TestSTB;
@RestController
public class PostController {
	private final STBRepositoryImpl stbRepo;
	@Autowired
    private STBService stbService;
	 @Autowired
	    public PostController(STBRepositoryImpl stbRepo) {
	        this.stbRepo = stbRepo;
	    }
	 private static final String INVALID_XML = "La stb ne respecte pas le format du xsd";

     
	 @PostMapping(value = "/stb23/insert", consumes = MediaType.APPLICATION_XML_VALUE)
	    public ResponseEntity<?> insertSTB(@RequestBody STB stb) {
	        // Validation du flux XML par rapport au schéma XSD

		 
		 if(!stbService.convertSTBToXMLAndValidate(stb, "stb.xml", "src/main/resources/stb23.xsd"))
	            throw new STBInvalidException(INVALID_XML);
	        

	        // Vérification si la STB existe déjà
	        if (stbRepo.existsByTitreAndVersionAndDate(stb.getId(), stb.getTitre(), stb.getDescription(), stb.getDate(), stb.getNomEntite())) {
	            ErrorXmlResponse errorResponse = new ErrorXmlResponse("ERROR", "DUPLICATED");
	            return ResponseEntity.ok(errorResponse);
	        }

	        // Génération de la valeur de l'identifiant
	        int lastId = stbRepo.getLastInsertedId();
	        int newId = lastId + 1;

	        stb.setId(Integer.toString(newId));
	        stb.setTitre(stb.getTitre());
	        stb.setDescription(stb.getDescription());
	        stb.setDate(stb.getDate());
	        stb.setNomEntite(stb.getNomEntite());

	        // Persistez la STB dans la base de données
	        stbRepo.save(stb);

	        // Renvoie une réponse contenant les informations de la STB ajoutée
	        STBXmlResponseInsert response = new STBXmlResponseInsert();
	        response.setId(Integer.toString(newId));
	        response.setStatus("INSERTED");
	        return ResponseEntity.ok(response);
	    }
	 
	 @DeleteMapping(value = "/stb23/delete/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	 public ResponseEntity<?> deleteSTB(@PathVariable("id") String id) {
	     try {
	         // Vérifier si la spécification existe
	         if (!stbService.existsById(id)) {
	             ErrorXmlResponse errorResponse = new ErrorXmlResponse("ERROR", "Unexisted");
	             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	         }

	         // Supprimer la spécification
	         stbService.deleteSTB(id);

	         // Créer la réponse XML contenant les informations de la spécification supprimée
	         STBXmlResponseInsert response = new STBXmlResponseInsert();
	         response.setId(id);
	         response.setStatus("DELETED");

	         return ResponseEntity.ok(response);
	     } catch (Exception e) {
	         ErrorXmlResponse errorResponse = new ErrorXmlResponse("ERROR", "");
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	     }
	 }


}

	
