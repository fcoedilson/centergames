/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author deivid
 *
 */
@Entity
@Table(name="cargo")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cargo implements Serializable, BaseEntity{

	private static final long serialVersionUID = 3350405586092044489L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcargo", unique=true, nullable=false)
	private Integer id;
	
	@Column(nullable=false, length=80)
	private String descricao;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Cargo other = (Cargo) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result = 1;
		result = 31 * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	

}
