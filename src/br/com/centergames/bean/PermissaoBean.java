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

import br.com.centergames.entity.Permissao;
import br.com.centergames.facade.PermissaoFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("permissaoBean")
public class PermissaoBean implements Serializable{

	private static final long serialVersionUID = 5778019727007673670L;
	
	private static final String LISTAGEM = "permissaoLista";
	private static final String NOVO = "permissao";
	
	private Permissao permissao;
	private Permissao permissaoSelecionada;
	private List<Permissao> lista;
	
	@Autowired
	private PermissaoFacade permissaoFacade;
	
	@PostConstruct
	public void init(){
		permissao = new Permissao();
		lista = permissaoFacade.findAll(permissao);
	}
	
	public String listar(){
		init();
		return LISTAGEM;
	}
	
	public String novo(){
		permissao = new Permissao();
		return NOVO;
	}
	
	public String voltar(){
		return LISTAGEM;
	}
	
	public String editar(){
		return NOVO;
	}
	
	public String salvar(){
		permissaoFacade.save(permissao);
		return listar();
	}
	
	public void excluir(){
		permissaoFacade.delete(permissao);
		listar();
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Permissao getPermissaoSelecionada() {
		return permissaoSelecionada;
	}

	public void setPermissaoSelecionada(Permissao permissaoSelecionada) {
		this.permissaoSelecionada = permissaoSelecionada;
	}

	public List<Permissao> getLista() {
		return lista;
	}

	public void setLista(List<Permissao> lista) {
		this.lista = lista;
	}

	public PermissaoFacade getPermissaoFacade() {
		return permissaoFacade;
	}

	public void setPermissaoFacade(PermissaoFacade permissaoFacade) {
		this.permissaoFacade = permissaoFacade;
	}

}
