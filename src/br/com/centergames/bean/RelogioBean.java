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

import br.com.centergames.entity.Relogio;
import br.com.centergames.facade.RelogioFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("relogioBean")
public class RelogioBean implements Serializable{

	private static final long serialVersionUID = -3462758282668717782L;
	
	private Relogio relogio;
	private Relogio relogioSelecionado;
	private List<Relogio> lista;
	@Autowired
	private RelogioFacade relogioFacade;
	
	@PostConstruct
	public void init(){
		relogio = new Relogio();
		lista = relogioFacade.findAll(relogio);
	}
	
	public String listar(){
		lista = relogioFacade.findAll(relogio);
		return "relogioLista";
	}
		
	public String novo(){
		relogio = new Relogio();
		return "relogio";
	}
	
	public String voltar(){
		return "relogioLista";
	}
	
	public String editar(){
		return "relogio";
	}
	
	public String salvar(){
		relogioFacade.save(relogio);
		return listar();
	}
	
	public void excluir(){
		relogioFacade.delete(relogio);
		relogio = new Relogio();
		listar();
	}

	public Relogio getRelogio() {
		return relogio;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public Relogio getRelogioSelecionado() {
		return relogioSelecionado;
	}

	public void setRelogioSelecionado(Relogio relogioSelecionado) {
		this.relogioSelecionado = relogioSelecionado;
	}

	public List<Relogio> getLista() {
		return lista;
	}

	public void setLista(List<Relogio> lista) {
		this.lista = lista;
	}

	public RelogioFacade getRelogioFacade() {
		return relogioFacade;
	}

	public void setRelogioFacade(RelogioFacade relogioFacade) {
		this.relogioFacade = relogioFacade;
	}

}
