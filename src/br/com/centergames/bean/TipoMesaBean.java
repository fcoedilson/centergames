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

import br.com.centergames.entity.TipoMesa;
import br.com.centergames.facade.TipoMesaFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("tpMesaBean")
public class TipoMesaBean implements Serializable{

	private static final long serialVersionUID = 422146131576985920L;
	
	private TipoMesa tpMesa;
	private TipoMesa tpMesaSelecionado;
	private List<TipoMesa> lista;
	
	@Autowired
	private TipoMesaFacade tpMesaFacade;
	
	@PostConstruct
	public void init(){
		tpMesa = new TipoMesa();
		lista = tpMesaFacade.findAll(tpMesa);
	}
	
	public String listar(){
		lista = tpMesaFacade.findAll(tpMesa);
		return "tpMesaLista";
	}
		
	public String novo(){
		tpMesa = new TipoMesa();
		return "tpMesa";
	}
	
	public String voltar(){
		return "tpMesaLista";
	}
	
	public String editar(){
		return "tpMesa";
	}
	
	public String salvar(){
		tpMesaFacade.save(tpMesa);
		return listar();
	}
	
	public void excluir(){
		tpMesaFacade.delete(tpMesa);
		tpMesa = new TipoMesa();
		listar();
	}

	public TipoMesa getTpMesa() {
		return tpMesa;
	}

	public void setTpMesa(TipoMesa tpMesa) {
		this.tpMesa = tpMesa;
	}

	public TipoMesa getTpMesaSelecionado() {
		return tpMesaSelecionado;
	}

	public void setTpMesaSelecionado(TipoMesa tpMesaSelecionado) {
		this.tpMesaSelecionado = tpMesaSelecionado;
	}

	public List<TipoMesa> getLista() {
		return lista;
	}

	public void setLista(List<TipoMesa> lista) {
		this.lista = lista;
	}

	public TipoMesaFacade getTpMesaFacade() {
		return tpMesaFacade;
	}

	public void setTpMesaFacade(TipoMesaFacade tpMesaFacade) {
		this.tpMesaFacade = tpMesaFacade;
	}

}
