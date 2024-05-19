package daoList;

import java.util.ArrayList;

import IF.CompensationList;
import domain.Compensation;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class CompensationListImpl implements CompensationList {

	private ArrayList<Compensation> compesnationList;
	public Compensation m_Compensation;

	public CompensationListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param compensation
	 */
	public void add(Compensation compensation){

	}

	/**
	 * 
	 * @param compensationID
	 */
	public void delete(int compensationID){

	}

	/**
	 * 
	 * @param compensationID
	 */
	public Compensation retrieve(int compensationID){
		return null;
	}

	/**
	 * 
	 * @param compensation
	 * @param compensationID
	 */
	public void update(Compensation compensation, int compensationID){

	}

}