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
@Table(name="cliente")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cliente implements Serializable, BaseEntity{

	private static final long serialVersionUID = 2003810175018907716L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcliente", unique=true, nullable=false)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@Column
	private String telefone;
	
	@Column
	private String rg;
	
	@Column(name="orgao_expedidor")
	private String orgaoExpedidor;
	
	@Column
	private String cpf;
	
	@Column
	private	String cgc;
	
	@Column
	private Boolean irregular;
	
	@Column(name="motivo_irreg")
	private String motivoIrregularidade;
	
	@Column
	private String observacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public Boolean getIrregular() {
		return irregular;
	}

	public void setIrregular(Boolean irregular) {
		this.irregular = irregular;
	}

	public String getMotivoIrregularidade() {
		return motivoIrregularidade;
	}

	public void setMotivoIrregularidade(String motivoIrregularidade) {
		this.motivoIrregularidade = motivoIrregularidade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		result = prime * result + ((cgc == null) ? 0 : cgc.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((irregular == null) ? 0 : irregular.hashCode());
		result = prime
				* result
				+ ((motivoIrregularidade == null) ? 0 : motivoIrregularidade
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result
				+ ((orgaoExpedidor == null) ? 0 : orgaoExpedidor.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cgc == null) {
			if (other.cgc != null)
				return false;
		} else if (!cgc.equals(other.cgc))
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
		if (irregular == null) {
			if (other.irregular != null)
				return false;
		} else if (!irregular.equals(other.irregular))
			return false;
		if (motivoIrregularidade == null) {
			if (other.motivoIrregularidade != null)
				return false;
		} else if (!motivoIrregularidade.equals(other.motivoIrregularidade))
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

	
}
