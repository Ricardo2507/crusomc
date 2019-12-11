package com.ricardo.cursomc.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.cursomc.domain.Estado;
import com.ricardo.cursomc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	/** receberá o arqgumento de pesquisa no banco de dados, no caso o id **/
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
		
		Estado obj = service.find(id);
		
		
		return ResponseEntity.ok().body(obj);
	}

}
