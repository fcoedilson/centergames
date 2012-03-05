package br.com.centergames.component;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.centergames.entity.User;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return findByUsername(username);
	}

	@SuppressWarnings("unchecked")
	private User findByUsername(String username) {
		try {
			List<User> users = hibernateTemplate.find("FROM User WHERE username = '"+username+"'");
			if(users != null && !users.isEmpty()){
				return users.get(0);
			}
			return null; 
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
	}
}
