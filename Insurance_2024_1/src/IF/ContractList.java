package IF;

import domain.Contract;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public interface ContractList {

	/**
	 * 
	 * @param Contract
	 */
	public void add(Contract Contract);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 
	 * @param id
	 */
	public Contract retrieve(int id);

	/**
	 * 
	 * @param id
	 * @param Contract
	 */
	public void update(int id, Contract Contract);

}