package daoList;

import java.util.ArrayList;

import IF.AccidentList;
import domain.Accident;

/**
 * @author junkyulee
 * @version 1.0
 * @created 16-5-2024 오후 6:54:55
 */
public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> AccidentList;
	public Accident m_Accident;

	public AccidentListImpl(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param accident
	 */
	public void add(Accident accident){

	}

	/**
	 * 
	 * @param accidentID
	 */
	public void delete(int accidentID){

	}

	/**
	 * 
	 * @param accidentID
	 */
	public Accident retrieve(int accidentID){
		return null;
	}

	/**
	 * 
	 * @param accident
	 * @param accidentID
	 */
	public void update(Accident accident, int accidentID){

	}

}