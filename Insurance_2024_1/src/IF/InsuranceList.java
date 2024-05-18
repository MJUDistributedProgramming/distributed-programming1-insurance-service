package IF;

import domain.Insurance;

/**
 * @author Owner
 * @version 1.0
 * @created 16-5-2024 오후 6:54:56
 */
public interface InsuranceList {

	/**
	 * 
	 * @param insurance
	 */
	public void add(Insurance insurance);

	/**
	 * 
	 * @param insuranceID
	 */
	public void delete(int insuranceID);

	/**
	 * 
	 * @param insuranceID
	 */
	public Insurance retrieve(int insuranceID);

	/**
	 * 
	 * @param insuranceID
	 * @param insurance
	 */
	public void update(int insuranceID, Insurance insurance);

}