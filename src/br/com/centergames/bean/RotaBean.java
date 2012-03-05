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

import br.com.centergames.entity.Rota;
import br.com.centergames.facade.RotaFacade;

/**
 * @author deivid
 *
 */
@Component("rotaBean")
@Scope("session")
public class RotaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Rota rota;
	private Rota rotaSelecionado;
	private List<Rota> lista;
	
	@Autowired
	private RotaFacade rotaFacade;
	
	@PostConstruct
	public void init(){
		setRota(new Rota());
		setLista(rotaFacade.findAll(rota));
	}
	
	public String listar(){
		lista = rotaFacade.findAll(rota);
		return "rotaLista";
	}
		
	public String novo(){
		rota = new Rota();
		return "rota";
	}
	
	public String voltar(){
		return "rotaLista";
	}
	
	public String editar(){
		return "rota";
	}
	
	public String salvar(){
		rotaFacade.save(rota);
		return listar();
	}
	
	public void excluir(){
		rotaFacade.delete(rota);
		rota = new Rota();
		listar();
	}
	

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public Rota getRotaSelecionado() {
		return rotaSelecionado;
	}

	public void setRotaSelecionado(Rota rotaSelecionado) {
		this.rotaSelecionado = rotaSelecionado;
	}

	public List<Rota> getLista() {
		return lista;
	}

	public void setLista(List<Rota> lista) {
		this.lista = lista;
	}

	public RotaFacade getRotaFacade() {
		return rotaFacade;
	}

	public void setRotaFacade(RotaFacade facade) {
		this.rotaFacade = facade;
	}

}
