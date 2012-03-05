/**
 * 
 */
package br.com.centergames.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.centergames.dao.GenericDAO;
import br.com.centergames.entity.Funcionario;
import br.com.centergames.entity.Locacao;
import br.com.centergames.entity.Mesa;

/**
 * @author deivid
 *
 */
@Repository
public class LocacaoFacade extends GenericDAO<Locacao> {

	@SuppressWarnings("unchecked")
	public List<Funcionario> findRepresentantesComLocacao() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select l.funcionario from Locacao l where l.funcionario is not null");
	}

	@SuppressWarnings("unchecked")
	public List<Mesa> findMesasLocadasRepresentantes(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("select l.mesa from Locacao l where l.funcionario.id = " +funcionario.getId());
	}

	public void encerrarLocacao(Locacao locacao) {
		// TODO Auto-generated method stub
		super.save(locacao);
	}

	@SuppressWarnings("unchecked")
	public List<Locacao> findLocacaoesAtivas(Locacao locacao) {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Locacao l where l.dataEncerramento is null");
	}

}
