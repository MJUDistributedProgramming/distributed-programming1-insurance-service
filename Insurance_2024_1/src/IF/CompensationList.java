package IF;

import domain.Compensation;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public interface CompensationList {

	/**
	 * 
	 * @param compensation
	 */
	public void add(Compensation compensation);

	/**
	 * 
	 * @param compensationID
	 */
	public void delete(int compensationID);

	/**
	 * 
	 * @param compensationID
	 */
	public Compensation retrieve(int compensationID);

	/**
	 * 
	 * @param compensation
	 * @param compensationID
	 */
	public void update(Compensation compensation, int compensationID);

}