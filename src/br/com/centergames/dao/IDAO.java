/**
 * 
 */
package br.com.centergames.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author deivid
 * 
 */
public interface IDAO<T extends Serializable> {
	void save(T entity);
	
	void delete(T entity);
	
	T findByDescricao(String descricao);

	List<T> findAll(T entity);
	
	T findById(T entity, Integer id);
}
