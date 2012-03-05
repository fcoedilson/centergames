/**
 * 
 */
package br.com.centergames.component;

import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.User;

/**
 * @author deivid
 * 
 */
@Component
public class AuthenticationService {
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	public boolean login(String username, String password) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					username, password);
			Authentication authenticate = authenticationManager
					.authenticate(token);
			if (authenticate.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(
						authenticate);
				return true;
			}
		} catch (AuthenticationException e) {
		}
		return false;
	}

	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		invalidateSession();
	}

	public User getUsuarioLogado() {
		return (User) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

	public String getRoleLogado() {
		Collection<GrantedAuthority> authorities = SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			return authority.getAuthority();
		}
		return null;
	}

	private void invalidateSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		session.invalidate();
	}
}
