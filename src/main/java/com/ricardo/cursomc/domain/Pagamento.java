package com.ricardo.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ricardo.cursomc.domain.enums.EstadoPagamento;

/** Inheritance --> herança**/

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	
	/** O Serializable PRECISA DE UM SERIAL **/
	private static final long serialVersionUID = 1L;
	
	/**  o id do pagamento é o mesmo do pedido . Logo não 
	 * colocamos @GeneratedValue(strategy=GenerationType.IDENTITY)**/
	@Id
	private Integer id;
	private Integer estado;
	
	
	/** como temos o mesmo id do pagto e do pedido, colocamos as anotações abaixo **/
	/**  MapsId é pra garantir que o Id do pagamento seja o mesmo do Pedido **/
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
   public Pagamento() {
	   
   }

public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
	super();
	this.id = id;
	this.estado = estado.getCod();
	this.pedido = pedido;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public EstadoPagamento getEstado() {
	return EstadoPagamento.toEnum(estado);
}

public void setEstado(EstadoPagamento estado) {
	this.estado = estado.getCod();
}

public Pedido getPedido() {
	return pedido;
}

public void setPedido(Pedido pedido) {
	this.pedido = pedido;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pagamento other = (Pagamento) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
	
   

}
