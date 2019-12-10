package com.ricardo.cursomc.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ricardo.cursomc.domain.Produto;

/** no Repository não será class, será interface extendendo JpaRepository  **/
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	

}
