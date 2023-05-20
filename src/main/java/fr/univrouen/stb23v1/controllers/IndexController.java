package fr.univrouen.stb23v1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import util.TestSTB;

@RestController

public class IndexController {
	@GetMapping(value = "/")
	  public ResponseEntity<String> getInfo()  {
		TestSTB stb = new TestSTB();

	    return ResponseEntity.ok(TestSTB.loadFileAccueil());
	  }
}

