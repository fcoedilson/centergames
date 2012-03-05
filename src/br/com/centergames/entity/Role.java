/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author deivid
 * 
 */
@Entity
@Table(name="role")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable, BaseEntity, GrantedAuthority {

	private static final long serialVersionUID = 8639638913547381215L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrole", nullable=false, unique=true)
	private Integer id;

	@Column(nullable = false, unique=true)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="role_permissao", joinColumns=@JoinColumn(name="idrole"), 
			inverseJoinColumns=@JoinColumn(name="idpermissao"))
	private List<Permissao> permissoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getName();
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
}
