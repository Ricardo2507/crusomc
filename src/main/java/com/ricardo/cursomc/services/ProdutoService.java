package com.ricardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ricardo.cursomc.domain.Produto;
import com.ricardo.cursomc.repositories.ProdutoRepository;
import com.ricardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
@Autowired
private ProdutoRepository repo;
	
	public Produto find(Integer id)  {
		/** a exceção será recebida pela camada REST(de recursos) **/
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
		
	}

}
