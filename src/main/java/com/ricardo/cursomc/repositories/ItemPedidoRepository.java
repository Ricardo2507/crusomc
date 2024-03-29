package com.ricardo.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.cursomc.domain.ItemPedido;

/** no Repository não será class, será interface extendendo JpaRepository  **/
/** faz parte da camada de acesso a dados  **/
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	
	

}
