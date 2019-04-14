/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.storage;

import java.util.List;

/**
 * Interface for all CRUD operations of DAO classes.
 *
 * @param <T> One of the intended model classes that a DAO implementation should be able to handle
 * @author Niklas Nordgren
 * @version 2019-02-18
 */

public interface IDao<T> {

	/**
	 * Gets the generic.
	 *
	 * @param id the id
	 * @return the generic
	 */
	T get(int id);
	
	/**
	 * Gets the a list of the generics.
	 *
	 * @return a list object of the generic type.
	 */
	List<T> getAll();
	
	/**
	 * Saves the generic.
	 *
	 * @param t the generic
	 */
	void save(T t);
	
	/**
	 * Update the generic.
	 *
	 * @param t the generic
	 */
	void update(T t);
	
	/**
	 * Delete the generic.
	 *
	 * @param t the generic
	 */
	void delete(T t);

}
