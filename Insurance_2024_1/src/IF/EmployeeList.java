package IF;

import domain.Employee;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public interface EmployeeList {

	/**
	 * 
	 * @param Employee
	 */
	public void add(Employee Employee);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 
	 * @param id
	 */
	public Employee retrieveById(int id);

	/**
	 * 
	 * @param id
	 * @param Employee
	 */
	public void update(int id, Employee Employee);

}