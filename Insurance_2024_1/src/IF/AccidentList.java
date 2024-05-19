package IF;

import domain.Accident;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public interface AccidentList {

	/**
	 * 
	 * @param accident
	 */
	public void add(Accident accident);

	/**
	 * 
	 * @param accidentID
	 */
	public void delete(int accidentID);

	/**
	 * 
	 * @param accidentID
	 */
	public Accident retrieve(int accidentID);

	/**
	 * 
	 * @param accident
	 * @param accidentID
	 */
	public void update(Accident accident, int accidentID);

}