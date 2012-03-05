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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author deivid
 *
 */
@Entity
@Table(name="mesa")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Mesa implements Serializable, BaseEntity{
	
	private static final long serialVersionUID = 6201427628838130726L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmesa", unique=true, nullable=false)
	private Integer id;
	
	@Column(unique=true)
	private String codigo;
		
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idtipo_mesa", nullable=false)
	private TipoMesa tipoMesa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idrelogio", nullable=false)
	private Relogio relogio;
	
	@Column
	private Boolean inativa;
	
	@Column(name="motivo_inatividade")
	private String motivoInatividade;
	
	@OneToOne(mappedBy="mesa", fetch=FetchType.EAGER)
	private Locacao locacao;
	
	@Column
	private String observacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoMesa getTipoMesa() {
		return tipoMesa;
	}

	public void setTipoMesa(TipoMesa tipoMesa) {
		this.tipoMesa = tipoMesa;
	}

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public Boolean getInativa() {
		return inativa;
	}

	public void setInativa(Boolean inativa) {
		this.inativa = inativa;
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

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Mesa other = (Mesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
