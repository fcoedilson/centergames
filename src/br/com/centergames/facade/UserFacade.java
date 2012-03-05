/**
 * 
 */
package br.com.centergames.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.centergames.dao.GenericDAO;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.User;

/**
 * @author deivid
 *
 */
@Repository
public class UserFacade extends GenericDAO<User>{
	
	@SuppressWarnings("unchecked")
	public Funcionario pesquisarFunc(String funcPesquisa) {
		// TODO Auto-generated method stub
		Funcionario funcionario = null;
		List<Funcionario> funcionarios = hibernateTemplate.find("from Funcionario f where f.cpf = '" +funcPesquisa+"'");
		if (!funcionarios.isEmpty()){
			funcionario = funcionarios.get(0);
		}
		return funcionario;
	}

}
