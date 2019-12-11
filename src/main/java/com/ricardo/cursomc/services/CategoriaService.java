package com.ricardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.cursomc.domain.Categoria;
import com.ricardo.cursomc.repositories.CategoriaRepository;
import com.ricardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	/** quando colocamos uma dependência dentro de uma classe e usamos a anotação Autowired **/
	/** essa dependência será automaticamente instanciada pelo Spring **/
	/** chama uma operação  de objeto de acesso a dados que faz parte do repositório **/
	/** declaramos a dependência do Repository **/
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id)  {
		/** a exceção será recebida pela camada REST(de recursos) **/
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
