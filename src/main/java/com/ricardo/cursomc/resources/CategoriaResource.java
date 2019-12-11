package com.ricardo.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardo.cursomc.domain.Categoria;
import com.ricardo.cursomc.dto.CategoriaDTO;
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
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		
		Categoria obj = service.find(id);
			
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		/** vamos converter a lista para uma lista de DTO**/
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
			
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam (value="page", defaultValue="0") Integer page, 
			@RequestParam (value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam (value="direction", defaultValue="ASC") String direction, 
			@RequestParam (value="orderBy", defaultValue="nome") String orderBy) {
		/** vamos converter a lista para uma lista de DTO**/
		Page<Categoria> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));
			
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	

}
