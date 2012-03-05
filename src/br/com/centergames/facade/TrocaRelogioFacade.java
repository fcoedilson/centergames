/**
 * 
 */
package br.com.centergames.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.centergames.dao.GenericDAO;
import br.com.centergames.entity.Mesa;
import br.com.centergames.entity.Relogio;
import br.com.centergames.entity.TrocaRelogio;

/**
 * @author deivid
 *
 */
@Repository
public class TrocaRelogioFacade extends GenericDAO<TrocaRelogio>{

	@SuppressWarnings("unchecked")
	public List<Mesa> findMesasLocadas() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select l.mesa from Locacao l where l.dataEncerramento is null");
	}

	@SuppressWarnings("unchecked")
	public List<Relogio> findRelogiosDisponiveis() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select l.mesa.relogio from Locacao l where l.dataEncerramento is not null");
	}

}
