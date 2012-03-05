/**
 * 
 */
package br.com.centergames.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Cliente;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.Locacao;
import br.com.centergames.entity.Mesa;
import br.com.centergames.entity.Relogio;
import br.com.centergames.entity.Rota;
import br.com.centergames.entity.TipoMesa;
import br.com.centergames.facade.LocacaoFacade;

/**
 * @author deivid
 *
 */
@Component("locacaoBean")
@Scope("session")
public class LocacaoBean implements Serializable{
	
	private static final String LISTAGEM = "locacaoLista";
	private static final String NOVO = "locacao";
	private static final String ENCERRAR = "encerrar";

	private static final long serialVersionUID = 97883505953809996L;
	
	private Locacao locacao;
	private Locacao locacaoSelecionado;
	private List<Locacao> lista;
	
	private List<Mesa> mesasSelecionadas;
	private List<Mesa> mesasRepresentantes;

	
	@Autowired
	private LocacaoFacade locacaoFacade;
	
	@PostConstruct
	public void init(){
		locacao = new Locacao();
		setLista(locacaoFacade.findLocacaoesAtivas(locacao));
	}
	
	public String prepareSave(){
		locacao = new Locacao();
		locacao.setMesa(new Mesa());
		locacao.getMesa().setTipoMesa(new TipoMesa());
		locacao.getMesa().setRelogio(new Relogio());
		locacao.setRota(new Rota());
		locacao.setFuncionario(new Funcionario());
		locacao.getFuncionario().setRotas(new ArrayList<Rota>());
		locacao.setCliente(new Cliente());
		return NOVO;
	}
	
	public String prepareEncerrar(){
		locacao = new Locacao();
		locacao.setMesa(new Mesa());
		locacao.getMesa().setTipoMesa(new TipoMesa());
		locacao.getMesa().setRelogio(new Relogio());
		locacao.setRota(new Rota());
		locacao.setFuncionario(new Funcionario());
		locacao.getFuncionario().setRotas(new ArrayList<Rota>());
		locacao.setCliente(new Cliente());
		setMesasRepresentantes(new ArrayList<Mesa>());
		return ENCERRAR;
	}
	
	public List<Funcionario> getRepresentantesComLocacao(){
		return locacaoFacade.findRepresentantesComLocacao();
	}
	
	public List<Mesa> mesasLocadasRepresentantes(){
		 mesasRepresentantes = locacaoFacade.findMesasLocadasRepresentantes(locacao.getFuncionario());
		 return mesasRepresentantes;
	}
	
	public String encerrar(){
		for (Mesa mesa : mesasSelecionadas) {
			Date dateAux = locacao.getDataEncerramento();
			locacao = mesa.getLocacao();
			locacao.setEncerrada(true);
			locacao.setDataEncerramento(dateAux);
			locacaoFacade.encerrarLocacao(locacao);
		}
		return listar();	
	}
	
	public String listar(){
		init();
		return LISTAGEM;
	}
	
	public String novo(){
		locacao = new Locacao();
		return NOVO;
	}
	
	public String voltar(){
		return LISTAGEM;
	}
	
	public String editar(){
		return NOVO;
	}
	
	public String salvar(){
		locacaoFacade.save(locacao);
		return listar();
	}
	
	public void excluir(){
		locacaoFacade.delete(locacao);
		locacao = new Locacao();
		listar();
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Locacao getLocacaoSelecionado() {
		return locacaoSelecionado;
	}

	public void setLocacaoSelecionado(Locacao locacaoSelecionado) {
		this.locacaoSelecionado = locacaoSelecionado;
	}

	public List<Locacao> getLista() {
		return lista;
	}

	public void setLista(List<Locacao> lista) {
		this.lista = lista;
	}

	public LocacaoFacade getLocacaoFacade() {
		return locacaoFacade;
	}

	public void setLocacaoFacade(LocacaoFacade locacaoFacade) {
		this.locacaoFacade = locacaoFacade;
	}

	public List<Mesa> getMesasSelecionadas() {
		return mesasSelecionadas;
	}

	public void setMesasSelecionadas(List<Mesa> mesasSelecionadas) {
		this.mesasSelecionadas = mesasSelecionadas;
	}

	public List<Mesa> getMesasRepresentantes() {
		return mesasRepresentantes;
	}

	public void setMesasRepresentantes(List<Mesa> mesasRepresentantes) {
		this.mesasRepresentantes = mesasRepresentantes;
	}

		
}
