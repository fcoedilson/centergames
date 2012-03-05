/**
 * 
 */
package br.com.centergames.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author deivid
 *
 */
@Entity
@Table(name="troca_relogio")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TrocaRelogio implements Serializable, BaseEntity{

	private static final long serialVersionUID = -1253212707655205525L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtroca_relogio", unique=true, nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idmesa", nullable=false)
	private Mesa mesa;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_troca", nullable=false)
	private Date dataTroca;
	
	@Column(name = "idrelogio_novo")
	private Relogio relogioNovo;
	
	@Column(name = "idrelogio_atual")
	private Relogio relogioAtual;
	
	@Column
	private String motivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getDataTroca() {
		return dataTroca;
	}

	public void setDataTroca(Date dataTroca) {
		this.dataTroca = dataTroca;
	}

	public Relogio getRelogioNovo() {
		return relogioNovo;
	}

	public void setRelogioNovo(Relogio relogioNovo) {
		this.relogioNovo = relogioNovo;
	}

	public Relogio getRelogioAtual() {
		return relogioAtual;
	}

	public void setRelogioAtual(Relogio relogioAtual) {
		this.relogioAtual = relogioAtual;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataTroca == null) ? 0 : dataTroca.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
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
		TrocaRelogio other = (TrocaRelogio) obj;
		if (dataTroca == null) {
			if (other.dataTroca != null)
				return false;
		} else if (!dataTroca.equals(other.dataTroca))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		return true;
	}
	
	

}
