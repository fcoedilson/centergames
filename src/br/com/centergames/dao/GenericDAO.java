/**
 * 
 */
package br.com.centergames.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import br.com.centergames.util.Messages;

/**
 * @author deivid
 *
 */
@Repository
public class GenericDAO<T extends Serializable> implements IDAO<T>{

	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			session.setFlushMode(FlushMode.MANUAL);
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(entity);
			session.flush();
			tx.commit();
			Messages.addInfo("Registro salvo com sucesso");
		}catch (HibernateException e) {
			// TODO: handle exception
			if (tx != null){
				Messages.addError("Não foi possivel salvar o registro!");
				tx.rollback();
				/* tratar exceção */
			}
		}		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			session.setFlushMode(FlushMode.MANUAL);
			tx = session.getTransaction();
			tx.begin();
			session.delete(entity);
			session.flush();
			tx.commit();	
			Messages.addInfo("Registro excluído com sucesso");
		}catch (ConstraintViolationException e) {
			// TODO: handle exception
			if (tx != null){
				Messages.addError("Existe filhos referentes ao registro!");
				tx.rollback();
				throw e; /* tratar exceção */
			}
		}catch (HibernateException e) {
			// TODO: handle exception
			if (tx != null){
				Messages.addError("Não foi possivel excluir o registro!");
				tx.rollback();
				throw e; /* tratar exceção */
			}
		}
	}

	@Override
	public T findByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(T entity) {
		// TODO Auto-generated method stub
		return (List<T>) hibernateTemplate.loadAll(entity.getClass());
	}
	
	@SuppressWarnings("unchecked")
	public T findById(T entity, Integer id){
		return (T) hibernateTemplate.get(entity.getClass().getName(), id);
	}

}
