/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author deivid
 *
 */
@Entity
@Table(name="relogio")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Relogio implements Serializable, BaseEntity{

	private static final long serialVersionUID = -5691130103818828244L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idrelogio", unique=true, nullable=false)
	private Integer id;
	
	@Column(nullable=false, length=45)
	private String numero;
	
	@Column(name = "leitura_anterior")
	private Integer leituraAnterior;
	
	@Column(name = "leitura_atual")
	private Integer leituraAtual;
	
	@OneToOne(mappedBy="relogio")
	private Mesa mesa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Relogio other = (Relogio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public Integer getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(Integer leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public Integer getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(Integer leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	

}
