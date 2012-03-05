/**
 * 
 */
package br.com.centergames.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.centergames.component.AuthenticationService;

/**
 * @author deivid
 * 
 */
@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {
	
	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;

	private String userName;
	private String password;

	public String login() {
		boolean success = authenticationService.login(userName, password);

		if (!success) {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "", "Login ou senha inválidos");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return "/login.jsf";
		}

		return "/pages/transacoes/locacao/locacaoLista.jsf";
	}
	
	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
