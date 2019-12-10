package com.ricardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.cursomc.domain.Pedido;
import com.ricardo.cursomc.repositories.PedidoRepository;
import com.ricardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	/** quando colocamos uma dependência dentro de uma classe e usamos a anotação Autowired **/
	/** essa dependência será automaticamente instanciada pelo Spring **/
	/** chama uma operação  de objeto de acesso a dados que faz parte do repositório **/
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id)  {
		/** a exceção será recebida pela camada REST(de recursos) **/
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		
	}

}
