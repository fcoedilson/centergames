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

import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.User;
import br.com.centergames.facade.UserFacade;
import br.com.centergames.util.Messages;

/**
 * @author deivid
 *
 */
@Component("userBean")
@Scope("session")
public class UserBean implements Serializable{

	private static final long serialVersionUID = 7453652563223303856L;
	
	private static final String LISTAGEM = "usuarioLista";
	private static final String NOVO = "usuario";
	
	private User user;
	private User userSelecionado;
	private List<User> lista;
	private String cpfFunc;
	private String nomeFunc;
	private Boolean desabilitaCadastro;
	
	
	@Autowired
	private UserFacade userFacade;
	
	@PostConstruct
	public void init(){
		setUser(new User());
		setLista(userFacade.findAll(user));
	}
	
	public void pesquisarFunc(){
		Funcionario funcionario = userFacade.pesquisarFunc(cpfFunc);
		if (funcionario == null){
			desabilitaCadastro = true;
			Messages.addInfo("Nenhum funcionário encontrado");
		}else{
			nomeFunc = funcionario.getNome();
			user.setFuncionario(funcionario);
			desabilitaCadastro = false;
		}
		
	}
	
	public String listar(){
		lista = userFacade.findAll(user);
		return LISTAGEM;
	}
		
	public String novo(){
		desabilitaCadastro = true;
		setUser(new User());
		return NOVO;
	}
	
	public String voltar(){
		return LISTAGEM;
	}
	
	public String editar(){
		return NOVO;
	}
	
	public String salvar(){
		userFacade.save(user);
		return listar();
	}
	
	public void excluir(){
		userFacade.delete(user);
		user = new User();
		listar();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserSelecionado() {
		return userSelecionado;
	}

	public void setUserSelecionado(User userSelecionado) {
		this.userSelecionado = userSelecionado;
	}

	public List<User> getLista() {
		return lista;
	}

	public void setLista(List<User> lista) {
		this.lista = lista;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public String getCpfFunc() {
		return cpfFunc;
	}

	public void setCpfFunc(String cpfFunc) {
		this.cpfFunc = cpfFunc;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public Boolean getDesabilitaCadastro() {
		return desabilitaCadastro;
	}

	public void setDesabilitaCadastro(Boolean desabilitaCadastro) {
		this.desabilitaCadastro = desabilitaCadastro;
	}
	

}
