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

import br.com.centergames.entity.Cliente;
import br.com.centergames.facade.ClienteFacade;

/**
 * @author deivid
 *
 */
@Component("clienteBean")
@Scope("session")
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = -2788636198043739492L;
	
	private Cliente cliente;
	private Cliente clienteSelecionado;
	private List<Cliente> lista;
	
	@Autowired
	private ClienteFacade clienteFacade;
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		lista = clienteFacade.findAll(cliente);
	}
	
	public String listar(){
		lista = clienteFacade.findAll(cliente);
		return "clienteLista";
	}
		
	public String novo(){
		cliente = new Cliente();
		return "cliente";
	}
	
	public String voltar(){
		return "clienteLista";
	}
	
	public String editar(){
		return "cliente";
	}
	
	public String salvar(){
		clienteFacade.save(cliente);
		return listar();
	}
	
	public void excluir(){
		clienteFacade.delete(cliente);
		cliente = new Cliente();
		listar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public ClienteFacade getClienteFacade() {
		return clienteFacade;
	}

	public void setClienteFacade(ClienteFacade clienteFacade) {
		this.clienteFacade = clienteFacade;
	}

}
