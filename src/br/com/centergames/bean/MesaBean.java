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

import br.com.centergames.entity.Mesa;
import br.com.centergames.entity.Relogio;
import br.com.centergames.facade.MesaFacade;
import br.com.centergames.util.Messages;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("mesaBean")
public class MesaBean implements Serializable{

	private static final long serialVersionUID = -1966046192263412536L;
	
	private Mesa mesa;
	private Mesa mesaSelecionado;
	private List<Mesa> lista;
	private List<Relogio> relogiosDisponiveis;
	
	private String pesquisa;
	
	@Autowired
	private MesaFacade mesaFacade;
	
	@PostConstruct
	public void init(){
		mesa = new Mesa();
		lista = mesaFacade.findAll(mesa);
	}
	
	public String listar(){
		lista = mesaFacade.findAll(mesa);
		return "mesaLista";
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> completeMesa(String filtro) {
		List<Mesa> mesas = (List<Mesa>) mesaFacade.findById(mesa, new Integer(filtro));
		return mesas;
	}

		
	public String novo(){
		mesa = new Mesa();
		relogiosDisponiveis = mesaFacade.findRelogiosDisponives();
		return "mesa";
	}
	
	public String voltar(){
		return "mesaLista";
	}
	
	public String editar(){
		return "mesa";
	}
	
	public String salvar(){
		if (verificaCodigo()){
			mesaFacade.save(mesa);
		}else{
			Messages.addError("Código da mesa já existente, cadastre outro!");
			return "";
		}
		return listar();
	}
	
	private boolean verificaCodigo() {
		// TODO Auto-generated method stub
		return mesaFacade.verificaCodigo(mesa.getCodigo());
	}

	public void excluir(){
		mesaFacade.delete(mesa);
		mesa = new Mesa();
		listar();
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesaSelecionado() {
		return mesaSelecionado;
	}

	public void setMesaSelecionado(Mesa mesaSelecionado) {
		this.mesaSelecionado = mesaSelecionado;
	}

	public List<Mesa> getLista() {
		return lista;
	}

	public void setLista(List<Mesa> lista) {
		this.lista = lista;
	}

	public MesaFacade getMesaFacade() {
		return mesaFacade;
	}

	public void setMesaFacade(MesaFacade mesaFacade) {
		this.mesaFacade = mesaFacade;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public List<Relogio> getRelogiosDisponiveis() {
		return relogiosDisponiveis;
	}

	public void setRelogiosDisponiveis(List<Relogio> relogiosDisponiveis) {
		this.relogiosDisponiveis = relogiosDisponiveis;
	}

}
