/**
 * 
 */
package br.com.centergames.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.Permissao;
import br.com.centergames.entity.Role;
import br.com.centergames.entity.User;



/**
 * @author deivid
 *
 */
@Scope("request")
@Component("controlBean")
public class ControlBean implements Serializable{

	private static final long serialVersionUID = -17829932946951981L;
	
	private User usuario;
	private Role grupo;
	private Set<String> permissoes;
	
	@PostConstruct
	public void init() throws ServletException, IOException {
		
		if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("permitAll")) {
			this.usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			this.permissoes = new HashSet<String>();
			this.grupo = this.usuario.getRole();
			for (Permissao permissao : grupo.getPermissoes()) {
				this.permissoes.add(permissao.getNome());
			}
			this.usuario.setPermissoes(this.permissoes);
		}
			
	}
	
	
	public boolean hasPermission(String... roles) {
		this.permissoes = this.usuario.getPermissoes();
		boolean permit = false;
		if (roles != null && roles.length > 0) {
			for (String s : roles) {
				if (this.permissoes.contains(s)) {
					permit = true;
					break;
				}
			}
		}
		return permit;
	}
	
}
