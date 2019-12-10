package com.ricardo.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.cursomc.domain.Pagamento;

/** no Repository não será class, será interface extendendo JpaRepository  **/
/** faz parte da camada de acesso a dados  **/
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
	

}
