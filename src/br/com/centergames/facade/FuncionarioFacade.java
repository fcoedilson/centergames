/**
 * 
 */
package br.com.centergames.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.centergames.dao.GenericDAO;
import br.com.centergames.entity.Estado;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.Rota;

/**
 * @author deivid
 *
 */
@Repository
public class FuncionarioFacade extends GenericDAO<Funcionario>{

	@SuppressWarnings("unchecked")
	public List<Funcionario> findRepresentantes() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Funcionario f where f.cargo.id = 1");
	}

	@SuppressWarnings("unchecked")
	public List<Rota> findRotasEstado(Estado estado) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Rota r where r.estado.id = "+estado.getId());
	}

}
