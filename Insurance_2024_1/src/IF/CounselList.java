package IF;

import domain.Counsel;

/**
 * @author yeil9
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public interface CounselList {

	/**
	 * 
	 * @param counsel
	 */
	public void add(Counsel counsel);

	/**
	 * 
	 * @param counselID
	 */
	public void delete(int counselID);

	/**
	 * 
	 * @param counselID
	 */
	public Counsel retrieve(int counselID);

	/**
	 * 
	 * @param counsel
	 * @param counselID
	 */
	public void update(Counsel counsel, int counselID);

}