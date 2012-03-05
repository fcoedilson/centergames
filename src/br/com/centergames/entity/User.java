/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author deivid
 * 
 */
@Entity
@Table(name = "user")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements Serializable, UserDetails, BaseEntity {

	private static final long serialVersionUID = 8100236550334166396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduser")
	private Integer id;

	@Column(name = "username", unique = true, nullable=false)
	private String username;

	@Column(name = "password", nullable=false)
	private String password;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idrole")
	private Role role;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idfuncionario")
	private Funcionario funcionario;
	
	 @Transient
	  public Collection<GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
	    result.add(new GrantedAuthorityImpl(role.getName()));
	    return result;
	  }

	@Transient
	private Set<String> permissoes;

	@Transient
	public Set<String> getPermissoes() {
		return this.permissoes;
	}

	@Transient
	public void setPermissoes(Set<String> permissoes) {
		this.permissoes = permissoes;
	}

	@Transient
	public boolean isEnabled() {
		return true;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	
}
