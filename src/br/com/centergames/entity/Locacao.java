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
import javax.persistence.OneToOne;
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
@Table(name="locacao_mesa")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Locacao implements Serializable{

	private static final long serialVersionUID = 3338753265031949869L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idlocacao", unique=true, nullable=false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="idmesa")
	private Mesa mesa;
	
	@OneToOne
	@JoinColumn(name="idfuncionario")
	private Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="idrota")
	private Rota rota;
	
	@OneToOne
	@JoinColumn(name="idvalor_ficha")
	private ValorFicha valorFicha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_locacao")
	private Date dataLocacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_encerramento")
	private Date dataEncerramento;
	
	@Column
	private Double lucro;
	
	@Column
	private Boolean encerrada;
	
	@Column
	private String observacoes;

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ValorFicha getValorFicha() {
		return valorFicha;
	}

	public void setValorFicha(ValorFicha valorFicha) {
		this.valorFicha = valorFicha;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Double getLucro() {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Boolean getEncerrada() {
		return encerrada;
	}

	public void setEncerrada(Boolean encerrada) {
		this.encerrada = encerrada;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataEncerramento == null) ? 0 : dataEncerramento.hashCode());
		result = prime * result
				+ ((dataLocacao == null) ? 0 : dataLocacao.hashCode());
		result = prime * result
				+ ((encerrada == null) ? 0 : encerrada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lucro == null) ? 0 : lucro.hashCode());
		result = prime * result
				+ ((observacoes == null) ? 0 : observacoes.hashCode());
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
		Locacao other = (Locacao) obj;
		if (dataEncerramento == null) {
			if (other.dataEncerramento != null)
				return false;
		} else if (!dataEncerramento.equals(other.dataEncerramento))
			return false;
		if (dataLocacao == null) {
			if (other.dataLocacao != null)
				return false;
		} else if (!dataLocacao.equals(other.dataLocacao))
			return false;
		if (encerrada == null) {
			if (other.encerrada != null)
				return false;
		} else if (!encerrada.equals(other.encerrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lucro == null) {
			if (other.lucro != null)
				return false;
		} else if (!lucro.equals(other.lucro))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		return true;
	}

}
