/**
 * 
 */
package br.com.centergames.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Estado;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.Rota;
import br.com.centergames.facade.FuncionarioFacade;

/**
 * @author deivid
 *
 */
@Component("funcBean")
@Scope("session")
public class FuncionarioBean implements Serializable{
	
	private static final long serialVersionUID = 9058953805417824436L;
	
	private Funcionario funcionario;
	private Funcionario funcionarioSelecionado;
	private List<Funcionario> lista;
	private List<Rota> rotas;
	private Estado estado;
	
	@Autowired
	private FuncionarioFacade funcionarioFacade;
	
	@PostConstruct
	public void init(){
		funcionario = new Funcionario();
		lista = funcionarioFacade.findAll(funcionario);
	}
	
	public List<Funcionario> getBuscarRepresentantes(){
		return funcionarioFacade.findRepresentantes();
	}
	
	public String listar(){
		lista = funcionarioFacade.findAll(funcionario);
		return "funcionarioLista";
	}
		
	public String novo(){
		funcionario = new Funcionario();
		setRotas(new ArrayList<Rota>());
		return "funcionario";
	}
	
	public void atualizaRotas(){
		rotas = funcionarioFacade.findRotasEstado(getEstado());
	}
	
	public String voltar(){
		return "funcionarioLista";
	}
	
	public String editar(){
		if (funcionario.getEstado() == null){
			setEstado(new Estado());
		}else{
			setEstado(funcionario.getEstado());
		}
		return "funcionario";
	}
	
	public String salvar(){
		funcionarioFacade.save(funcionario);
		return listar();
	}
	
	public void excluir(){
		funcionarioFacade.delete(funcionario);
		funcionario = new Funcionario();
		listar();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public List<Funcionario> getLista() {
		return lista;
	}

	public void setLista(List<Funcionario> lista) {
		this.lista = lista;
	}

	public FuncionarioFacade getFuncionarioFacade() {
		return funcionarioFacade;
	}

	public void setFuncionarioFacade(FuncionarioFacade funcionarioFacade) {
		this.funcionarioFacade = funcionarioFacade;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		atualizaRotas();
	}

}
