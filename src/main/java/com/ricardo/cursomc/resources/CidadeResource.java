package com.ricardo.cursomc.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.cursomc.domain.Cidade;
import com.ricardo.cursomc.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	/** receberá o arqgumento de pesquisa no banco de dados, no caso o id **/
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cidade> find(@PathVariable Integer id) {
		
		Cidade obj = service.find(id);
		
		
		return ResponseEntity.ok().body(obj);
	}

}
