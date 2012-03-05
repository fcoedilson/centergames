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

import br.com.centergames.entity.ValorFicha;
import br.com.centergames.facade.ValorFichaFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("vlFichaBean")
public class ValorFichaBean implements Serializable{

	private static final long serialVersionUID = 6183462188971896731L;
	
	private ValorFicha vlFicha;
	private ValorFicha vlFichaSelecionado;
	private List<ValorFicha> lista;
	
	@Autowired
	private ValorFichaFacade vlFichaFacade;
	
	@PostConstruct
	public void init(){
		vlFicha = new ValorFicha();
		lista = vlFichaFacade.findAll(vlFicha);
	}
	
	public String listar(){
		lista = vlFichaFacade.findAll(vlFicha);
		return "vlFichaLista";
	}
		
	public String novo(){
		vlFicha = new ValorFicha();
		return "vlFicha";
	}
	
	public String voltar(){
		return "vlFichaLista";
	}
	
	public String editar(){
		return "vlFicha";
	}
	
	public String salvar(){
		vlFichaFacade.save(vlFicha);
		return listar();
	}
	
	public void excluir(){
		vlFichaFacade.delete(vlFicha);
		vlFicha = new ValorFicha();
		listar();
	}

	public ValorFicha getVlFicha() {
		return vlFicha;
	}

	public void setVlFicha(ValorFicha vlFicha) {
		this.vlFicha = vlFicha;
	}

	public ValorFicha getVlFichaSelecionado() {
		return vlFichaSelecionado;
	}

	public void setVlFichaSelecionado(ValorFicha vlFichaSelecionado) {
		this.vlFichaSelecionado = vlFichaSelecionado;
	}

	public List<ValorFicha> getLista() {
		return lista;
	}

	public void setLista(List<ValorFicha> lista) {
		this.lista = lista;
	}

	public ValorFichaFacade getVlFichaFacade() {
		return vlFichaFacade;
	}

	public void setVlFichaFacade(ValorFichaFacade vlFichaFacade) {
		this.vlFichaFacade = vlFichaFacade;
	}
	
}
