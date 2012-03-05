/**
 * 
 */
package br.com.centergames.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.centergames.dao.GenericDAO;
import br.com.centergames.entity.Mesa;
import br.com.centergames.entity.Relogio;

/**
 * @author deivid
 *
 */
@Repository
public class MesaFacade extends GenericDAO<Mesa> {

	@SuppressWarnings("unchecked")
	public List<Relogio> findRelogiosDisponives() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select r from Relogio r where r.id not in (select m.relogio.id from Mesa m)");
	}

	@SuppressWarnings("unchecked")
	public Boolean verificaCodigo(String codigo) {
		// TODO Auto-generated method stub
		List<Mesa> mesas = hibernateTemplate.find("from Mesa m where m.codigo = "+codigo);
		if(mesas != null && !mesas.isEmpty()){
			return false;
		}
		return true;
	}

}
