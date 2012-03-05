/**
 * 
 */
package br.com.centergames.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import br.com.centergames.entity.Estado;

/**
 * @author deivid
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("centergames");
		EntityManager em = factory.createEntityManager();
		EntityTransaction tm = em.getTransaction();
		tm.begin();
		Estado estado = new Estado();
		estado.setNome("teste");
		estado.setSigla("TE");
		em.persist(estado);
		tm.commit();
		em.close();
		factory.close();
	}

}
