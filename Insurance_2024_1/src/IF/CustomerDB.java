package IF;

import domain.Customer;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public interface CustomerDB {

	/**
	 * 
	 * @param Customer
	 */
	public void add(Customer Customer);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 
	 * @param id
	 */
	public Customer retrieve(int id);

	/**
	 * 
	 * @param id
	 * @param Customer
	 */
	public void update(int id, Customer Customer);

}