/**
 * 
 */
package br.com.centergames.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Estado;
import br.com.centergames.facade.EstadoFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("estadoBean")
public class EstadoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Estado estado;
	private Estado estadoSelecionado;
	private List<Estado> lista;
	
	@Autowired
	private EstadoFacade estadoFacade;
	
	@PostConstruct
	public void init(){
		estado = new Estado();
		lista = estadoFacade.findAll(estado);
	}
	
	public String listar(){
		lista = estadoFacade.findAll(estado);
		return "estadoLista";
	}
		
	public String novo(){
		estado = new Estado();
		return "estado";
	}
	
	public String voltar(){
		return "estadoLista";
	}
	
	public String editar(){
		return "estado";
	}
	
	public String salvar(){
		estadoFacade.save(estado);
		return listar();
	}
	
	public void excluir(){
		estadoFacade.delete(estado);
		estado = new Estado();
		listar();
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}
	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
	
	public EstadoFacade getEstadoFacade() {
		return estadoFacade;
	}

	public void setEstadoFacade(EstadoFacade facade) {
		this.estadoFacade = facade;
	}

	public List<Estado> getLista() {
		return lista;
	}

	public void setLista(List<Estado> lista) {
		this.lista = lista;
	}
}
