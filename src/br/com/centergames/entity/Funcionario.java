/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author deivid
 *
 */
@Entity
@Table(name="funcionario")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Funcionario implements Serializable, BaseEntity{

	private static final long serialVersionUID = -3545773563490427154L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idfuncionario", unique=true, nullable=false)
	private Integer id;
	
	@Column
	private String telefone;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idcargo", nullable=false)
	private Cargo cargo;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="funcionario_rotas",
		joinColumns=@JoinColumn(name="idfuncionario"),
		inverseJoinColumns=@JoinColumn(name="idrota"))
	private Collection<Rota> rotas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idestado",nullable=false)
	private Estado estado;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@Column
	private String rg;
	
	@Column(name="orgao_expedidor")
	private String orgaoExpedidor;
	
	@Column
	private String cpf;
	
	@Column(name="perc_gratificacao")
	private Double perctGratificacao;
	
	@Column
	private Boolean representante;
	
	@Column
	private Boolean inativo;
	
	@Column(name="motivo_inatividade")
	private String motivoInatividade;
	
	@Column
	private String observacoes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getPerctGratificacao() {
		return perctGratificacao;
	}

	public void setPerctGratificacao(Double perctGratificacao) {
		this.perctGratificacao = perctGratificacao;
	}

	public Boolean getRepresentante() {
		return representante;
	}

	public void setRepresentante(Boolean representante) {
		this.representante = representante;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

	public String getMotivoInatividade() {
		return motivoInatividade;
	}

	public void setMotivoInatividade(String motivoInatividade) {
		this.motivoInatividade = motivoInatividade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Collection<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(Collection<Rota> rotas) {
		this.rotas = rotas;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inativo == null) ? 0 : inativo.hashCode());
		result = prime
				* result
				+ ((motivoInatividade == null) ? 0 : motivoInatividade
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result
				+ ((orgaoExpedidor == null) ? 0 : orgaoExpedidor.hashCode());
		result = prime
				* result
				+ ((perctGratificacao == null) ? 0 : perctGratificacao
						.hashCode());
		result = prime * result
				+ ((representante == null) ? 0 : representante.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inativo == null) {
			if (other.inativo != null)
				return false;
		} else if (!inativo.equals(other.inativo))
			return false;
		if (motivoInatividade == null) {
			if (other.motivoInatividade != null)
				return false;
		} else if (!motivoInatividade.equals(other.motivoInatividade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (orgaoExpedidor == null) {
			if (other.orgaoExpedidor != null)
				return false;
		} else if (!orgaoExpedidor.equals(other.orgaoExpedidor))
			return false;
		if (perctGratificacao == null) {
			if (other.perctGratificacao != null)
				return false;
		} else if (!perctGratificacao.equals(other.perctGratificacao))
			return false;
		if (representante == null) {
			if (other.representante != null)
				return false;
		} else if (!representante.equals(other.representante))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
		
}
