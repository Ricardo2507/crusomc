package com.ricardo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.cursomc.domain.Categoria;
import com.ricardo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	/** A anotação @ Autowired fornece controle sobre onde e como a ligação 
	 * entre os beans deve ser realizada. Pode ser usado para em métodos 
	 * setter, no construtor, em uma propriedade ou métodos com nomes
	 *  arbitrários e / ou vários argumentos.
	 */
	
	@Autowired
	private CategoriaService service;
	
	/** receberá o arqgumento de pesquisa no banco de dados, no caso o id **/
	/** ResponseEntity --> armazana várias informações de uma resposta HTTP para um serviço REST**/
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		
		
		return ResponseEntity.ok().body(obj);
	}

}
