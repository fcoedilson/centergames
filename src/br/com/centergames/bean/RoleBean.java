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

import br.com.centergames.entity.Role;
import br.com.centergames.facade.RoleFacade;

/**
 * @author deivid
 *
 */
@Scope("session")
@Component("roleBean")
public class RoleBean implements Serializable{
	
	private static final String LISTAGEM = "grupoLista";
	private static final String NOVO = "grupo";

	private static final long serialVersionUID = 567370648080406813L;
	
	private Role role;
	private Role roleSelecionado;
	private List<Role> lista;
	@Autowired
	private RoleFacade roleFacade;
	
	
	@PostConstruct
	public void init(){
		role = new Role();
		lista = roleFacade.findAll(role);
	}
	
	public String listar(){
		lista = roleFacade.findAll(role);
		return LISTAGEM;
	}
		
	public String novo(){
		role = new Role();
		return NOVO;
	}
	
	public String voltar(){
		return LISTAGEM;
	}
	
	public String editar(){
		return NOVO;
	}
	
	public String salvar(){
		roleFacade.save(role);
		return listar();
	}
	
	public void excluir(){
		roleFacade.delete(role);
		role = new Role();
		listar();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRoleSelecionado() {
		return roleSelecionado;
	}

	public void setRoleSelecionado(Role roleSelecionado) {
		this.roleSelecionado = roleSelecionado;
	}

	public List<Role> getLista() {
		return lista;
	}

	public void setLista(List<Role> lista) {
		this.lista = lista;
	}

	public RoleFacade getRoleFacade() {
		return roleFacade;
	}

	public void setRoleFacade(RoleFacade roleFacade) {
		this.roleFacade = roleFacade;
	}

}
