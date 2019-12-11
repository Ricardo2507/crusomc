package com.ricardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.cursomc.domain.Estado;
import com.ricardo.cursomc.repositories.EstadoRepository;
import com.ricardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	/** quando colocamos uma dependência dentro de uma classe e usamos a anotação Autowired **/
	/** essa dependência será automaticamente instanciada pelo Spring **/
	/** chama uma operação  de objeto de acesso a dados que faz parte do repositório **/
	/** declaramos a dependência do Repository **/
	
	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id)  {
		/** a exceção será recebida pela camada REST(de recursos) **/
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
		
	}

}
