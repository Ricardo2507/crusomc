package com.ricardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.cursomc.domain.Cidade;
import com.ricardo.cursomc.repositories.CidadeRepository;
import com.ricardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	/** quando colocamos uma dependência dentro de uma classe e usamos a anotação Autowired **/
	/** essa dependência será automaticamente instanciada pelo Spring **/
	/** chama uma operação  de objeto de acesso a dados que faz parte do repositório **/
	/** declaramos a dependência do Repository **/
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id)  {
		/** a exceção será recebida pela camada REST(de recursos) **/
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
		
	}

}
